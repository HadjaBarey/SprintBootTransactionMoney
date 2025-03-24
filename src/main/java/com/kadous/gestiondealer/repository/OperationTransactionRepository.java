package com.kadous.gestiondealer.repository;

import org.springframework.transaction.annotation.Transactional;
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
    

}

