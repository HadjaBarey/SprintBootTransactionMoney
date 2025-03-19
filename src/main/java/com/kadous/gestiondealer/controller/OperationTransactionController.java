package com.kadous.gestiondealer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kadous.gestiondealer.controller.api.OperationTransactionApi;
import com.kadous.gestiondealer.dto.OperationTransactionDTO;
import com.kadous.gestiondealer.services.OperationTransactionService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Permet l'accès à l'application Nuxt.js
public class OperationTransactionController implements OperationTransactionApi{

    @Autowired
    private OperationTransactionService operationTransactionService;

        
    public ResponseEntity<String> saveAll(@RequestBody List<OperationTransactionDTO> operations) {
        System.out.println("📥 Données reçues dans Spring Boot : " + operations);

        if (operations == null || operations.isEmpty()) {
            return ResponseEntity.badRequest().body("❌ Aucune donnée reçue !");
        }

        // Sauvegarde en base
        operationTransactionService.saveAll(operations);
        return ResponseEntity.ok("✅ Données enregistrées avec succès !");
    }

    
    public OperationTransactionController(
        OperationTransactionService operationTransactionService
    ) {
        this.operationTransactionService = operationTransactionService;
    }
        
    @Override
    public OperationTransactionDTO save(OperationTransactionDTO dto) {
        return operationTransactionService.save(dto);
    }

    @Override
    public OperationTransactionDTO findById(Integer id) {
        return operationTransactionService.findById(id);
    }

    @Override
    public List<OperationTransactionDTO> findAll() {
        return operationTransactionService.findAll();
    }

    @Override
    public void delete(Integer id) {
        operationTransactionService.delete(id);
    }

    @Override
    public OperationTransactionDTO update(Integer id, OperationTransactionDTO dto) {
        return operationTransactionService.update(id, dto);
    }


}

