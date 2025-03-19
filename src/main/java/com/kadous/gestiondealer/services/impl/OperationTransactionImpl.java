package com.kadous.gestiondealer.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.kadous.gestiondealer.dto.OperationTransactionDTO;
import com.kadous.gestiondealer.exception.EntityNotFoundException;
import com.kadous.gestiondealer.exception.ErrorCodes;
import com.kadous.gestiondealer.exception.InvalidEntityException;
import com.kadous.gestiondealer.model.OperationTransaction;
import com.kadous.gestiondealer.repository.OperationTransactionRepository;
import com.kadous.gestiondealer.services.OperationTransactionService;
import com.kadous.gestiondealer.validator.OperationTransactionValidator;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OperationTransactionImpl implements OperationTransactionService{

   @Autowired
    private OperationTransactionRepository opTransactionRepository;      
    public OperationTransactionImpl(OperationTransactionRepository OpTransactionRepository){
        this.opTransactionRepository=OpTransactionRepository;
    }


    @Override
    public OperationTransactionDTO save(OperationTransactionDTO dto) {
        List<String> errors = OperationTransactionValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("L'opération n'est pas valide {}", dto);
            throw new InvalidEntityException("L'opération n'est pas valide, Veuillez revoir vos données.", 
            ErrorCodes.OPERATION_TRANSACTION_NOT_VALID, errors);
        }

        OperationTransaction operationTransaction = dto.toEntity(dto);
        OperationTransaction savedOperationTransaction = opTransactionRepository.save(operationTransaction);
        return OperationTransactionDTO.fromEntity(savedOperationTransaction);

    }
    

    @Override
    public OperationTransactionDTO findById(Integer id) {
        if (id == null) {
            log.error("Le code de l'opération est null");
            return null;
        }

        return opTransactionRepository.findById(id).map(OperationTransactionDTO::fromEntity).orElseThrow(() ->
            new EntityNotFoundException(
                "Aucune opération avec l'ID " + id + " n' a été trouvé dans la BD",
                ErrorCodes.OPERATION_TRANSACTION_NOT_FOUND)
        );
    }


   @Override
    public List<OperationTransactionDTO> findAll() {
        return opTransactionRepository.findAll().stream().map(OperationTransactionDTO::fromEntity)
            .collect(Collectors.toList());
    }

    @Override
    public List<OperationTransactionDTO> saveAll(List<OperationTransactionDTO> dtos) {
    // Validation et sauvegarde des données
    List<String> errors = new ArrayList<>();
    for (OperationTransactionDTO dto : dtos) {
        errors.addAll(OperationTransactionValidator.validate(dto));
    }

    if (!errors.isEmpty()) {
        log.error("Les données sont invalides {}", dtos);
        throw new InvalidEntityException("Données invalides", ErrorCodes.OPERATION_TRANSACTION_NOT_VALID, errors);
    }

    // Convertir les DTO en entités
    List<OperationTransaction> operations = dtos.stream()
            .map(dto -> dto.toEntity(dto))  // Convertir chaque DTO en entité
            .collect(Collectors.toList());

    // Sauvegarder les entités dans la base de données
    List<OperationTransaction> savedOperations = opTransactionRepository.saveAll(operations);

    // Retourner les DTO correspondants
    return savedOperations.stream()
            .map(OperationTransactionDTO::fromEntity)
            .collect(Collectors.toList());
    }



    @Override
    public void delete(Integer id) {
        if (id == null) {
        log.error("Le code de l'opération est null");
        return;
        }
        opTransactionRepository.deleteById(id);
  
    }

    @Override
    public OperationTransactionDTO update(Integer id, OperationTransactionDTO dto) {
        if (id == null) {
            log.error("L'ID de l'opération est null");
            return null;
        }

        OperationTransactionDTO existingRole = findById(id);
        if (existingRole == null) {
            log.error("Le code de l'opération avec l'ID {} n'existe pas", id);
            throw new EntityNotFoundException("Aucune opération avec l'ID " + id + " n'a été trouvé", 
            ErrorCodes.OPERATION_TRANSACTION_NOT_FOUND);
        }

        List<String> errors = OperationTransactionValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Le code de l'opération mis à jour n'est pas valide {}", dto);
            throw new InvalidEntityException("L'opération mise à jour n'est pas valide", 
            ErrorCodes.OPERATION_TRANSACTION_NOT_VALID, errors);
        }

    
        dto.setIdoperation(id); // Assurez-vous que l'ID est correctement transféré au DTO mis à jour
        OperationTransaction operationTransaction = dto.toEntity(dto);
        OperationTransaction savedOperationTransaction = opTransactionRepository.save(operationTransaction);
        return OperationTransactionDTO.fromEntity(savedOperationTransaction);

    }

    
    

}

