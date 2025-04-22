package com.kadous.gestiondealer.dto;

import java.time.Instant;
import com.kadous.gestiondealer.model.UsersKey;
import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class UsersKeyDto {

    private Integer numauto;
    private String numeroaleatoire; 
    private Instant created_at;
    private Instant updated_at;


    public static UsersKeyDto fromEntity(UsersKey usersKey) {
        if (usersKey == null) {
          return null;
        }
    
        return new UsersKeyDto(
            usersKey.getNumauto(),
            usersKey.getNumeroaleatoire(),
            usersKey.getCreated_at(),
            usersKey.getUpdated_at()

        );
    }

    public UsersKey toEntity(UsersKeyDto dto) {
        if (dto == null) {
          return null;
        }
    
        UsersKey usersKey = new UsersKey();
      //  usersKey.setNumauto(this.getNumauto());
        usersKey.setNumeroaleatoire(this.getNumeroaleatoire()); 
        usersKey.setCreated_at(this.getCreated_at());
        usersKey.setUpdated_at(this.getUpdated_at());
        
        return usersKey;
    }
    


    
}
