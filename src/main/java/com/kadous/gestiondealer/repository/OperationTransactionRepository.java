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

//SUPPRESION DES DONNEES DANS SPRINT BOOT EN DE LA DATE CHOISIE, DU NUMERO DE TELEPHONE, ET DU MOT DE PASSE SIL EST RENSEIGNE DEPUIS SPRINT BOOT AVANT DE TRANSFERER LA NOUVELLE DONNEE DE L'UTILSATEUR AVEC LE MOT DE PASSE SPECIFIQUE    
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM t_operation_transaction WHERE numero_tel_entreprise =:telEntreprise AND dateoperation =:dateOp AND emailentreprise =:emailEP", nativeQuery = true)
    void deleteTransaction(
        @Param("telEntreprise") String telEntreprise,
        @Param("dateOp") String dateOp,
        @Param("emailEP") String emailEP
    );

//RECUPERATION DES DONNEES DEPUIS SPRINT BOOT POUR EXPORTER DANS FLUTTER EN FONCTION DU NUMERO, DE LA DATE, ET DU MOT DE PASSE DE L'URILISATEUR 
    //@Query(value = "SELECT * FROM t_operation_transaction WHERE numero_tel_entreprise =:entrepriseNumero  AND dateoperation =:dateopera AND emailentreprise like :emailEPR;", nativeQuery = true)
    @Query(value = "SELECT t_operation_transaction.*, t_userskey.* FROM t_operation_transaction, t_userskey WHERE t_operation_transaction.numero_tel_entreprise like :entrepriseNumero AND t_operation_transaction.dateoperation =:dateopera AND t_operation_transaction.emailentreprise LIKE :emailEPR AND t_userskey.numeroaleatoire =:numalea;", nativeQuery = true)
    List<Map<String,Object>> listTransaction(
        @Param("entrepriseNumero") String entrepriseNumero,
        @Param("dateopera") String dateopera,
        @Param("emailEPR") String emailEPR,
        @Param("numalea") String numalea
    );

//RECHERCHE EN FONCTION DU NUMERO DE TELEPHONE DEPUIS SPRINTBOOT
    @Query(value = "SELECT * FROM t_operation_transaction WHERE numero_telephone =:numerotelephone AND dateoperation >= :datedebut AND dateoperation <= :datefin;", nativeQuery = true)
    List<Map<String,Object>> listRechercher(
        @Param("numerotelephone") String numerotelephone,
        @Param("datedebut") String datedebut,
        @Param("datefin") String datefin

    );

}

