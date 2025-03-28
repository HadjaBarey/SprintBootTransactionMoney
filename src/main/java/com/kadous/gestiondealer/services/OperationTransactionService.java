package com.kadous.gestiondealer.services;

import java.util.List;

import com.kadous.gestiondealer.dto.OperationTransactionDTO;

public interface OperationTransactionService {

    OperationTransactionDTO save(OperationTransactionDTO dto);

    OperationTransactionDTO findById(Integer id);

    List<OperationTransactionDTO> findAll();

    OperationTransactionDTO update(Integer id, OperationTransactionDTO dto);

    void delete(Integer id);

    List<OperationTransactionDTO> saveAll(List<OperationTransactionDTO> dtos);

    void SupprimerOpera(String telEntreprise,String dateOp);

    
}
