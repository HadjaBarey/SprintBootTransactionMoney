package com.kadous.gestiondealer.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kadous.gestiondealer.model.Users;





public interface UsersRepository extends JpaRepository<Users, Integer>{

    Users findByEmail(String email);

       //Permet de renvoyer une liste des clients pour la saisie des opérations de transfert internationaux
    @Query(value = "SELECT * FROM users where email=:rechercherEmail;", nativeQuery = true)
    List<Map<String,Object>> utilisateurInfo(
        @Param("rechercherEmail") String rechercherEmail
    );

}
