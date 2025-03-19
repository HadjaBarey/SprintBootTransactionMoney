package com.kadous.gestiondealer.validator;

import java.util.ArrayList;
import java.util.List;

import com.kadous.gestiondealer.dto.FichierDto;

public class FichierValidator {

    public static List<String> validate(FichierDto dto) {
        List<String> errors = new ArrayList<>();
    
        if (dto == null) {
            errors.add("Veuillez renseigner la grille avant de poursuivre!");
            return errors;
        }

        if (dto.getDatesauvegarde()== null || dto.getDatesauvegarde().equals("")) {
            errors.add("Veuillez renseigner le date de la transaction");
        }
        if (dto.getUsers()== null || dto.getUsers().equals("")) {
            errors.add("Veuillez renseigner l'utilisateur");
        }
        
        if (dto.getOperationTransaction()== null || dto.getOperationTransaction().equals("")) {
            errors.add("Veuillez renseigner la transaction");
        }
        return errors;
    }

}

