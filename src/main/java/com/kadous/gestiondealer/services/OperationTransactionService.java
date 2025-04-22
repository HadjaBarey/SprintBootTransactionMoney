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

    void SupprimerOpera(String telEntreprise,String dateOp,String emailEP);

    List<?> listTransaction(String entrepriseNumero, String dateopera, String emailEPR, String numalea);

    List<?> listRechercher(String numerotelephone, String datedebut, String datefin);

    

}
