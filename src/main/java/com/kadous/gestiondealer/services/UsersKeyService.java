package com.kadous.gestiondealer.services;

import java.util.List;

import com.kadous.gestiondealer.dto.UsersKeyDto;

public interface UsersKeyService {

    UsersKeyDto save(UsersKeyDto dto);

    UsersKeyDto findById(Integer id);

    List<UsersKeyDto> findAll();

    UsersKeyDto update(Integer id, UsersKeyDto dto);

    void delete(Integer id);

    List<UsersKeyDto> saveAll(List<UsersKeyDto> dtos);
    

}
