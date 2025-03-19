package com.kadous.gestiondealer.services;

import java.util.List;

import com.kadous.gestiondealer.dto.UsersDto;

public interface UsersService {

    UsersDto save(UsersDto dto);

    UsersDto findById(Integer id);

    List<UsersDto> findAll();

    void delete(Integer id);

    UsersDto update(Integer id, UsersDto dto);

    List<?> utilisateurInfo(String rechercheEmail); 
}
