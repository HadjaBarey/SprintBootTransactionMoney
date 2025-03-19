package com.kadous.gestiondealer.auth;

import java.time.Instant;

import com.kadous.gestiondealer.model.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String identiteag;
  private String matricule;
  private String email;
  private String password;
  private Role role;
  private Integer status;
  private Integer cloturer;
  private String refcnib; 
  private String telephone; 
  private String sexe;
  private Instant updated_at;
  private Instant created_at;
  
}
