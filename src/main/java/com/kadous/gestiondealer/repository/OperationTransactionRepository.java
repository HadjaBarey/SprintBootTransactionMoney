package com.kadous.gestiondealer.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kadous.gestiondealer.model.OperationTransaction;


public interface OperationTransactionRepository extends JpaRepository<OperationTransaction, Integer>{
  
}

