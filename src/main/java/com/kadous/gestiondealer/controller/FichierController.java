package com.kadous.gestiondealer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.kadous.gestiondealer.controller.api.FichierApi;
import com.kadous.gestiondealer.dto.FichierDto;
import com.kadous.gestiondealer.services.FichierService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Permet l'accès à l'application Nuxt.js
public class FichierController implements FichierApi {

    private final FichierService fichierService;

    public FichierController(FichierService fichierService) {
        this.fichierService = fichierService;
    }

    @Override
    public FichierDto save(FichierDto dto) {
        return fichierService.save(dto);
    }

    @Override
    public FichierDto findById(Integer id) {
        return fichierService.findById(id);
    }

    @Override
    public List<FichierDto> findAll() {
        return fichierService.findAll();
    }

    @Override
    public void delete(Integer id) {
        fichierService.delete(id);
    }

    @Override
    public FichierDto update(Integer id, FichierDto dto) {
        return fichierService.update(id, dto);
    }

}
