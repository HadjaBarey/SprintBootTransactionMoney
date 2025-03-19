package com.kadous.gestiondealer.controller.api;

import static com.kadous.gestiondealer.utils.Constants.APP_ROOT;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kadous.gestiondealer.dto.FichierDto;

@RequestMapping(APP_ROOT + "/Fichier")
public interface FichierApi {
    
    @PostMapping("/create")
    FichierDto save(@RequestBody FichierDto dto);

    @GetMapping("/{idFichier}")
    FichierDto findById(@PathVariable("idFichier") Integer id);

    @GetMapping("/all")
    List<FichierDto> findAll();

    @DeleteMapping("/delete/{idFichier}")
    void delete(@PathVariable("idFichier") Integer id);

    @PutMapping("/update/{idFichier}")
    FichierDto update(@PathVariable("idFichier") Integer id, @RequestBody FichierDto dto);
}

