package com.kadous.gestiondealer.dto;


import com.kadous.gestiondealer.model.Users;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersDto {
    private Integer id; // Si nécessaire
    private String identiteag;
    private String sexe;
    private String telephone;
    private String refcnib;
    private String email;
    private String matricule;
    private String password;
    private Integer cloturer;
    private Integer status;
    private String mot2passejava;

    // Méthode pour convertir un UsersDto en Users
    public Users toEntity() {
        Users user = new Users();
        user.setId(this.id);
        user.setIdentiteag(this.identiteag);
        user.setSexe(this.sexe);
        user.setTelephone(telephone);
        user.setRefcnib(this.refcnib);
        user.setEmail(this.email);
        user.setMatricule(this.matricule);
        user.setPassword(this.password);
        user.setCloturer(this.cloturer);
        user.setStatus(this.status);
        user.setMot2passejava(this.mot2passejava);
        return user;
    }

    // Méthode pour convertir un Users en UsersDto
    public static UsersDto fromEntity(Users user) {
        if(user==null){
            return null;
        }
        return new UsersDto(
                user.getId(),
                user.getIdentiteag(),
                user.getSexe(),
                user.getTelephone(),
                user.getRefcnib(),
                user.getEmail(),
                user.getMatricule(),
                user.getPassword(),
                user.getCloturer(),
                user.getStatus(),
                user.getMot2passejava()
                
        );
    }
}