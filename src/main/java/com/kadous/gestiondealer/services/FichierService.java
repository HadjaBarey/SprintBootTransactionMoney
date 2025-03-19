package com.kadous.gestiondealer.services;

import java.util.List;

import com.kadous.gestiondealer.dto.FichierDto;

public interface FichierService {

    FichierDto save(FichierDto dto);

    FichierDto findById(Integer id);

    List<FichierDto> findAll();

    void delete(Integer id);

    FichierDto update(Integer id, FichierDto dto);

}