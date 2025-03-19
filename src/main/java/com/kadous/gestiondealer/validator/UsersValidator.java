package com.kadous.gestiondealer.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.kadous.gestiondealer.dto.UsersDto;

public class UsersValidator {
  public static List<String> validate(UsersDto dto) {
    List<String> errors = new ArrayList<>();

    if (dto == null) {
      errors.add("Veuillez renseigner la grille avant de poursuivre!");
      return errors;
    }

    // if (dto.getId()==null) {
    //   errors.add("Veuillez renseigner le code de l'utilisateur");
    // }
    if (!StringUtils.hasLength(dto.getIdentiteag())) {
      errors.add("Veuillez renseigner le nom de l'utilisateur");
    }
    if (!StringUtils.hasLength(dto.getSexe())) {
        errors.add("Veuillez renseigner le sex de l'utilisateur");
    }
    if (!StringUtils.hasLength(dto.getRefcnib())) {
    errors.add("Veuillez renseigner la CNIB de l'utilisateur");
    }
    if (!StringUtils.hasLength(dto.getEmail())) {
    errors.add("Veuillez renseigner le email de l'utilisateur");
    }
    if (!StringUtils.hasLength(dto.getMatricule())) {
    errors.add("Veuillez renseigner le matricule de l'utilisateur");
    }
    if (!StringUtils.hasLength(dto.getPassword())) {
    errors.add("Veuillez renseigner le mot de passe de l'utilisateur");
    }
    

    return errors;
  }
}
