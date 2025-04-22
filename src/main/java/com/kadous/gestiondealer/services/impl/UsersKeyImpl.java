package com.kadous.gestiondealer.services.impl;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kadous.gestiondealer.dto.UsersKeyDto;
import com.kadous.gestiondealer.exception.EntityNotFoundException;
import com.kadous.gestiondealer.exception.ErrorCodes;
import com.kadous.gestiondealer.exception.InvalidEntityException;
import com.kadous.gestiondealer.model.UsersKey;
import com.kadous.gestiondealer.repository.UsersKeyRepository;
import com.kadous.gestiondealer.services.UsersKeyService;
import com.kadous.gestiondealer.validator.UsersKeyValidator;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class UsersKeyImpl implements UsersKeyService{

   @Autowired
    private UsersKeyRepository uKeyRepository;      

    public UsersKeyImpl(UsersKeyRepository UKeyRepository){
        this.uKeyRepository=UKeyRepository;
    }


    @Override
    public UsersKeyDto save(UsersKeyDto dto) {
        List<String> errors = UsersKeyValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("La clé n'est pas valide {}", dto);
            throw new InvalidEntityException("La clé n'est pas valide, Veuillez revoir vos données.", 
            ErrorCodes.USESRSKEY_NOT_VALID, errors);
        }

        UsersKey usersKey = dto.toEntity(dto);
        UsersKey savedUsersKey = uKeyRepository.save(usersKey);
        return UsersKeyDto.fromEntity(savedUsersKey);

    }
    

    @Override
    public UsersKeyDto findById(Integer id) {
        if (id == null) {
            log.error("Le code de la clé est null");
            return null;
        }

        return uKeyRepository.findById(id).map(UsersKeyDto::fromEntity).orElseThrow(() ->
            new EntityNotFoundException(
                "Aucune clé avec l'ID " + id + " n' a été trouvé dans la BD",
                ErrorCodes.USESRSKEY_NOT_FOUND)
        );
    }


   @Override
    public List<UsersKeyDto> findAll() {
        return uKeyRepository.findAll().stream().map(UsersKeyDto::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public List<UsersKeyDto> saveAll(List<UsersKeyDto> dtos) {
    // Validation et sauvegarde des données
    List<String> errors = new ArrayList<>();
    for (UsersKeyDto dto : dtos) {
        errors.addAll(UsersKeyValidator.validate(dto));
    }

    if (!errors.isEmpty()) {
        log.error("Les données sont invalides {}", dtos);
        throw new InvalidEntityException("Données invalides", ErrorCodes.OPERATION_TRANSACTION_NOT_VALID, errors);
    }

    // Convertir les DTO en entités
    List<UsersKey> skey = dtos.stream()
            .map(dto -> dto.toEntity(dto))  // Convertir chaque DTO en entité
            .collect(Collectors.toList());

    // Sauvegarder les entités dans la base de données
    List<UsersKey> savedskey = uKeyRepository.saveAll(skey);

    // Retourner les DTO correspondants
    return savedskey.stream()
            .map(UsersKeyDto::fromEntity)
            .collect(Collectors.toList());
    }



    @Override
    public void delete(Integer id) {
        if (id == null) {
        log.error("Le code de la clé est null");
        return;
        }
        uKeyRepository.deleteById(id);
  
    }

    @Override
    public UsersKeyDto update(Integer id, UsersKeyDto dto) {
        if (id == null) {
            log.error("Le code de la clé est null");
            return null;
        }

        UsersKeyDto existingRole = findById(id);
        if (existingRole == null) {
            log.error("Le code de la clé avec l'ID {} n'existe pas", id);
            throw new EntityNotFoundException("Aucune opération avec l'ID " + id + " n'a été trouvé", 
            ErrorCodes.USESRSKEY_NOT_FOUND);
        }

        List<String> errors = UsersKeyValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Le code de la clé mis à jour n'est pas valide {}", dto);
            throw new InvalidEntityException("La clé mise à jour n'est pas valide", 
            ErrorCodes.USESRSKEY_NOT_VALID, errors);
        }

    
        dto.setNumauto(id); // Assurez-vous que l'ID est correctement transféré au DTO mis à jour
        UsersKey usersKey = dto.toEntity(dto);
        UsersKey savedUsersKey = uKeyRepository.save(usersKey);
        return UsersKeyDto.fromEntity(savedUsersKey);

    }
    


    

}

