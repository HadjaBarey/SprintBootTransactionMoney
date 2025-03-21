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
    @Query(value = "DELETE FROM t_operation_transaction WHERE dateoperation =:dateoperation", nativeQuery = true)
    void deleteTransaction(
        @Param("dateoperation") String dateoperation
    );

    // @Transactional
    // @Modifying
    // @Query(value = "DELETE FROM t_operation_transaction WHERE STR_TO_DATE(dateoperation, '%d/%m/%Y') = STR_TO_DATE(:dateoperation, '%Y-%m-%d')", nativeQuery = true)
    // int deleteTransaction(
    //     @Param("dateoperation") String dateoperation
    //     );



}

