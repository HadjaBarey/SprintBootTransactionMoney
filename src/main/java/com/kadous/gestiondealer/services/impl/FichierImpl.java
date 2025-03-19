package com.kadous.gestiondealer.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kadous.gestiondealer.exception.EntityNotFoundException;
import com.kadous.gestiondealer.exception.ErrorCodes;
import com.kadous.gestiondealer.exception.InvalidEntityException;
import com.kadous.gestiondealer.dto.FichierDto;
import com.kadous.gestiondealer.model.Fichier;
import com.kadous.gestiondealer.model.OperationTransaction;
import com.kadous.gestiondealer.model.Users;
import com.kadous.gestiondealer.repository.FichierRepository;
import com.kadous.gestiondealer.repository.OperationTransactionRepository;
import com.kadous.gestiondealer.repository.UsersRepository;
import com.kadous.gestiondealer.validator.FichierValidator;
import com.kadous.gestiondealer.services.FichierService;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FichierImpl implements FichierService{
    
    @Autowired
    private FichierRepository fichierRepository;
    private OperationTransactionRepository operationTransactionRepository;
    private UsersRepository usersRepository; 
    public FichierImpl(FichierRepository fichierRepository,OperationTransactionRepository operationTransactionRepository,UsersRepository usersRepository){
        this.fichierRepository=fichierRepository;
        this.operationTransactionRepository=operationTransactionRepository;
        this.usersRepository=usersRepository;
    }

    @Override
    public FichierDto save(FichierDto dto) {
        List<String> errors =FichierValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Le fichier n'est pas valide {}", dto);
            throw new InvalidEntityException("L'opérateur n'est pas valide", ErrorCodes.FICHIER_NOT_VALID, errors);
        }

        
        Users users = usersRepository.findById(dto.getUsers())
        .orElseThrow(() -> new RuntimeException("Users not found"));

        OperationTransaction operationTransaction = operationTransactionRepository.findById(dto.getOperationTransaction())
        .orElseThrow(() -> new RuntimeException("Transaction not found"));

        Fichier fichier = dto.toEntity(dto,users,operationTransaction);
        Fichier savedFichier = fichierRepository.save(fichier);
        return FichierDto.fromEntity(savedFichier);
    }

    @Override
    public FichierDto findById(Integer id) {
        if (id == null) {
            log.error("ID de opérateur est null");
            return null;
        }

        return fichierRepository.findById(id).map(FichierDto::fromEntity).orElseThrow(() ->
            new EntityNotFoundException(
                "Aucun opérateur avec l'ID = " + id + " n' a été trouvé dans la BDD",
                ErrorCodes.FICHIER_NOT_FOUND)
        );
    }

    @Override
    public List<FichierDto> findAll() {
        return fichierRepository.findAll().stream()
            .map(FichierDto::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
        log.error("L'ID du fichier est null");
        return;
        }

        fichierRepository.deleteById(id);
  
    }

    @Override
    public FichierDto update(Integer id, FichierDto dto) {
        if (id == null) {
            log.error("L'ID du fichier est null");
            return null;
        }

        FichierDto existingRole = findById(id);
        if (existingRole == null) {
            log.error("Le fichier avec l'ID {} n'existe pas", id);
            throw new EntityNotFoundException("Aucun fichier avec l'ID " + id + " n'a été trouvé", 
            ErrorCodes.FICHIER_NOT_FOUND);
        }

        List<String> errors = FichierValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Le fichier mis à jour n'est pas valide {}", dto);
            throw new InvalidEntityException("Le fichier mis à jour n'est pas valide", 
            ErrorCodes.FICHIER_NOT_VALID, errors);
        }

         
        Users users = usersRepository.findById(dto.getUsers())
        .orElseThrow(() -> new RuntimeException("Users not found"));

        OperationTransaction operationTransaction = operationTransactionRepository.findById(dto.getOperationTransaction())
        .orElseThrow(() -> new RuntimeException("Transaction not found"));

        dto.setIdfichier(id); // Assurez-vous que l'ID est correctement transféré au DTO mis à jour
        Fichier fichier = dto.toEntity(dto,users,operationTransaction);
        Fichier savedFichier = fichierRepository.save(fichier);
        return FichierDto.fromEntity(savedFichier);
    }


}
