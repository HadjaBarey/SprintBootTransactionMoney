package com.kadous.gestiondealer.repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadous.gestiondealer.model.OperationTransaction;


public interface OperationTransactionRepository extends JpaRepository<OperationTransaction, Integer>{

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM t_operation_transaction WHERE numero_tel_entreprise =:telEntreprise AND dateoperation =:dateOp", nativeQuery = true)
    void deleteTransaction(
        @Param("telEntreprise") String telEntreprise,
        @Param("dateOp") String dateOp
    );


    @Query(value = "SELECT * FROM t_operation_transaction WHERE numero_tel_entreprise =:entrepriseNumero  AND dateoperation =:dateopera ;", nativeQuery = true)
    List<Map<String,Object>> listTransaction(
        @Param("entrepriseNumero") String entrepriseNumero,
        @Param("dateopera") String dateopera
    );

    

}

