package com.kadous.gestiondealer.validator;

import java.util.ArrayList;
import java.util.List;

import com.kadous.gestiondealer.dto.UsersKeyDto;


public class UsersKeyValidator {

    public static List<String> validate(UsersKeyDto dto) {
        List<String> errors = new ArrayList<>();
    
        if (dto == null) {
            errors.add("Veuillez renseigner la grille avant de poursuivre!");
            return errors;
        }

        if (dto.getNumauto()== null || dto.getNumauto().equals("")) {
            errors.add("Veuillez renseigner le numéro ");
        }
        // if (dto.getNumeroaleatoire()== null || dto.getNumeroaleatoire().equals("")) {
        //     errors.add("Veuillez renseigner les information ");
        // }
        
        return errors;
    }

    
}
