package com.kadous.gestiondealer.model;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Integer> {

  Optional<Users> findByEmail(String email);

}
