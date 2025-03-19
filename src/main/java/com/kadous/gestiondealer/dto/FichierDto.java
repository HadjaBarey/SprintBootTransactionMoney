package com.kadous.gestiondealer.dto;

import java.time.Instant;
import java.time.LocalDate;

import com.kadous.gestiondealer.model.OperationTransaction;
import com.kadous.gestiondealer.model.Users;
import com.kadous.gestiondealer.model.Fichier;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FichierDto {
    private Integer idfichier;// Si nécessaire
    private LocalDate datesauvegarde;
    private Integer supprimer;
    private Integer operationTransaction; // Id pour la relation avec operationTransaction
    private Integer users; // Id pour la relation avec users
    private Instant created_at;   
    private Instant updated_at;


    // Méthode pour convertir un Users en FichierDto
    public static FichierDto fromEntity(Fichier fichier) {
        if (fichier == null) {
          return null;
        }
    
        return new FichierDto(
            fichier.getIdfichier(),
            fichier.getDatesauvegarde(),
            fichier.getSupprimer(),
            fichier.getOperationTransaction() !=null ? fichier.getOperationTransaction().getIdoperation():null,
            fichier.getUsers() !=null ? fichier.getUsers().getId():null,
            fichier.getCreated_at(),
            fichier.getUpdated_at()
          //.build();
        );
      }


    public Fichier toEntity(FichierDto dto,Users users,OperationTransaction operationTransaction) {
        if (dto == null) {
          return null;
        }
    
        Fichier fichier = new Fichier();
        fichier.setIdfichier(this.idfichier);
        fichier.setDatesauvegarde(this.datesauvegarde);
        fichier.setSupprimer(this.supprimer);
        fichier.setUsers(users);
        fichier.setOperationTransaction(operationTransaction);
        fichier.setCreated_at(this.created_at);
        fichier.setUpdated_at(this.updated_at);

        
        return fichier;
    }

}