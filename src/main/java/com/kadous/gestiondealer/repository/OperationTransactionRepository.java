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
    @Query(value = "DELETE FROM t_operation_transaction WHERE numero_tel_entreprise =:telEntreprise AND dateoperation =:dateOp AND emailentreprise =:emailEP", nativeQuery = true)
    void deleteTransaction(
        @Param("telEntreprise") String telEntreprise,
        @Param("dateOp") String dateOp,
        @Param("emailEP") String emailEP
    );


    @Query(value = "SELECT * FROM t_operation_transaction WHERE numero_tel_entreprise =:entrepriseNumero  AND dateoperation =:dateopera AND emailentreprise like :emailEPR;", nativeQuery = true)
    List<Map<String,Object>> listTransaction(
        @Param("entrepriseNumero") String entrepriseNumero,
        @Param("dateopera") String dateopera,
        @Param("emailEPR") String emailEPR
    );

    @Query(value = "SELECT * FROM t_operation_transaction WHERE numero_telephone =:numerotelephone AND dateoperation >= :datedebut AND dateoperation <= :datefin;", nativeQuery = true)
    List<Map<String,Object>> listRechercher(
        @Param("numerotelephone") String numerotelephone,
        @Param("datedebut") String datedebut,
        @Param("datefin") String datefin

    );

}

