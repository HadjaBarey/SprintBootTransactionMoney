package com.kadous.gestiondealer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.kadous.gestiondealer.controller.api.UsersKeyApi;
import com.kadous.gestiondealer.dto.UsersKeyDto;
import com.kadous.gestiondealer.services.UsersKeyService;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UsersKeyController implements UsersKeyApi{

    @Autowired
    private UsersKeyService usersKeyService;

        
    public ResponseEntity<String> saveAll(@RequestBody List<UsersKeyDto> USKey) {
        System.out.println("📥 Données reçues dans Spring Boot : " + USKey);

        if (USKey == null || USKey.isEmpty()) {
            return ResponseEntity.badRequest().body("❌ Aucune donnée reçue !");
        }

        // Sauvegarde en base
        usersKeyService.saveAll(USKey);
        return ResponseEntity.ok("✅ Données enregistrées avec succès !");
    }

    
    public UsersKeyController(
        UsersKeyService usersKeyService
    ) {
        this.usersKeyService = usersKeyService;
    }
        
    @Override
    public UsersKeyDto save(UsersKeyDto dto) {
        return usersKeyService.save(dto);
    }

    @Override
    public UsersKeyDto findById(Integer id) {
        return usersKeyService.findById(id);
    }

    @Override
    public List<UsersKeyDto> findAll() {
        return usersKeyService.findAll();
    }

    @Override
    public void delete(Integer id) {
        usersKeyService.delete(id);
    }

    @Override
    public UsersKeyDto update(Integer id, UsersKeyDto dto) {
        return usersKeyService.update(id, dto);
    }


   
}

