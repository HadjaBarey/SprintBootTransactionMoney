package com.kadous.gestiondealer.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadous.gestiondealer.dto.UsersDto;
import com.kadous.gestiondealer.exception.EntityNotFoundException;
import com.kadous.gestiondealer.exception.ErrorCodes;
import com.kadous.gestiondealer.exception.InvalidEntityException;
//import com.kadous.gestiondealer.model.Fonctionuser;
import com.kadous.gestiondealer.model.Users;
//import com.kadous.gestiondealer.repository.T_operationRepository;
import com.kadous.gestiondealer.repository.UsersRepository;
import com.kadous.gestiondealer.services.UsersService;
import com.kadous.gestiondealer.validator.UsersValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersRepository usersRepository;

        public UsersServiceImpl(UsersRepository usersRepository){
        this.usersRepository=usersRepository;
    }

    @Override
    public UsersDto save(UsersDto dto) {
        List<String> errors = UsersValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Utilisateur n'est pas valide {}", dto);
            throw new InvalidEntityException("Utilisateur n'est pas valide", ErrorCodes.USERS_NOT_VALID, errors);
        }
        // Fonctionuser fonctionuser = fonctionRepository.findById(dto.getFonctionuser())
        //         .orElseThrow(() -> new RuntimeException("Fonctionuser not found"));
                
        Users user = dto.toEntity();
        Users savedUser = usersRepository.save(user);
        return UsersDto.fromEntity(savedUser);
    }

    @Override
    public UsersDto findById(Integer id) {
        if (id == null) {
            log.error("User ID is null");
            return null;
        }

        return usersRepository.findById(id).map(UsersDto::fromEntity).orElseThrow(() ->
            new EntityNotFoundException(
                "Aucun utilisateur avec l'ID = " + id + " n'a été trouvé dans la BDD",
                ErrorCodes.USERS_NOT_FOUND)
        );
    }


    @Override
    public List<?> utilisateurInfo(String rechercheEmail) {
        if (rechercheEmail==null) {
            log.error("L'option de recherche  est null");
            return null;
        }
        return usersRepository.utilisateurInfo(rechercheEmail);
        
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepository.findAll().stream()
            .map(UsersDto::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("L'ID de l'utilisateur est null");
            return;
        }
        // Décommenter si vous souhaitez empêcher la suppression des utilisateurs associés à des opérations
        // List<T_operation> operation = t_operationRepository.findAllByUsersId(id);
        // if (!operation.isEmpty()) {
        //     throw new InvalidOperationException("Impossible de supprimer un utilisateur déjà utilisé dans des opérations", 
        //         ErrorCodes.USERS_ALREADY_IN_USE);
        // }

        usersRepository.deleteById(id);
    }

    @Override
    public UsersDto update(Integer id, UsersDto dto) {
        if (id == null) {
            log.error("L'ID de l'utilisateur est null");
            return null;
        }

        UsersDto existingUser = findById(id);
        if (existingUser == null) {
            log.error("L'utilisateur avec l'ID {} n'existe pas", id);
            throw new EntityNotFoundException("Aucun utilisateur avec l'ID " + id + " n'a été trouvé", ErrorCodes.USERS_NOT_FOUND);
        }

        List<String> errors = UsersValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("L'utilisateur mis à jour n'est pas valide {}", dto);
            throw new InvalidEntityException("L'utilisateur mis à jour n'est pas valide", ErrorCodes.USERS_NOT_VALID, errors);
        }

  

        dto.setId(id); // Assurez-vous que l'ID est correctement transféré au DTO mis à jour
        Users user = dto.toEntity();
        Users savedUser = usersRepository.save(user);
        return UsersDto.fromEntity(savedUser);
    }
}
