package com.kadous.gestiondealer.validator;

import java.util.ArrayList;
import java.util.List;

import com.kadous.gestiondealer.dto.OperationTransactionDTO;

public class OperationTransactionValidator {

    public static List<String> validate(OperationTransactionDTO dto) {
        List<String> errors = new ArrayList<>();
    
        if (dto == null) {
            errors.add("Veuillez renseigner la grille avant de poursuivre!");
            return errors;
        }

        if (dto.getIdoperation()== null || dto.getIdoperation().equals("")) {
            errors.add("Veuillez renseigner le numéro de téléphone");
        }

        if (dto.getNumeroTelephone()== null || dto.getNumeroTelephone().equals("")) {
            errors.add("Veuillez renseigner le numéro de téléphone");
        }
        if (dto.getInfoClient()== null || dto.getInfoClient().equals("")) {
            errors.add("Veuillez renseigner les information du client");
        }
        
        if (dto.getTypeoperation() == null || dto.getTypeoperation().equals("")) {
            errors.add("Veuillez renseigner le type de l'opération");
        }
        if (dto.getOperateur() == null || dto.getOperateur().equals("")) {
        errors.add("Veuillez renseigner l'opérateur de l'opération");
        }

        if (dto.getIdtrans() == null || dto.getIdtrans().equals("")) {
            errors.add("Veuillez renseigner l'Id de la transaction");
        }
        if (dto.getDateoperation() == null || dto.getDateoperation().equals("")) {
            errors.add("Veuillez renseigner la date de la journée");
        }
        if (dto.getMontant() == null || dto.getMontant().equals("")) {
            errors.add("Veuillez renseigner le montant de l'opération");
        }
        return errors;
    }

    
}
