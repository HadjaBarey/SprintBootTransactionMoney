package com.kadous.gestiondealer.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.kadous.gestiondealer.controller.api.UsersApi;
import com.kadous.gestiondealer.dto.UsersDto;
import com.kadous.gestiondealer.services.UsersService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Permet l'accès à l'application Nuxt.js
public class UsersController implements UsersApi {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @Override
    public UsersDto save(UsersDto dto) {
        return usersService.save(dto);
    }

    @Override
    public UsersDto findById(Integer id) {
        return usersService.findById(id);
    }

    @Override
    public List<UsersDto> findAll() {
        return usersService.findAll();
    }

    @Override
    public void delete(Integer id) {
        usersService.delete(id);
    }

    @Override
    public UsersDto update(Integer id, UsersDto dto) {
        return usersService.update(id, dto);
    }

    @Override
    public List<?> utilisateurInfo(String rechercheEmail) {
        return usersService.utilisateurInfo(rechercheEmail);
    }

}
