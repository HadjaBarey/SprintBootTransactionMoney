package com.kadous.gestiondealer.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)//Permet de renseigner automatiquement les dates created_at et updated_at
@Table(name = "t_OperationTransaction")

public class OperationTransaction {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true,length=20,name = "codeoperation")
    private Integer codeoperation;

    @Column(nullable = false,length=11,name = "idoperation")
    private Integer idoperation;

    @Column(nullable = false,name = "dateoperation")
    private String dateoperation;

    @Column(nullable = false,name = "montant")
    private String montant;

    @Column(nullable = false,length=11,name = "numeroTelephone")
    private String numeroTelephone;

   @Lob
    @Column(nullable = false,columnDefinition = "LONGTEXT",name = "infoClient")
    private String infoClient;

    @Column(nullable = false,length=11,name = "typeoperation")
    private Integer typeoperation;

    @Column(nullable = false,length=11,name = "operateur")
    private String operateur;

    @Column(length=11,name = "supprimer")
    private Integer supprimer;

    @Column(length=11,name = "iddette")
    private Integer iddette;

    @Column(columnDefinition = "boolean default false", name = "optioncreance")
    private Boolean optioncreance = false;

    @Lob
    @Column(columnDefinition = "LONGTEXT", name = "scanmessage")
    private String scanmessage;

    @Column(length=11,name = "numeroindependant")
    private String numeroindependant;

    @Column(nullable = false,length=191,name = "idtrans")
    private String idtrans;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updated_at;

    //---Option entreprise recuperation--------------------------------------

    @Column(nullable = false,length=191,name = "numeroTelEntreprise ")
    private String numeroTelEntreprise ;


    // @Column(nullable = false,length=11,name = "idEntreprise")
    // private Integer idEntreprise;

    // @Column(nullable = false,length=191,name = "nomEntreprise")
    // private String nomEntreprise;

    // @Column(nullable = false,length=191,name = "directeurEntreprise")
    // private String directeurEntreprise;

    // @Column(nullable = false,length=191,name = "numeroTelephoneEntreprise ")
    // private String numeroTelephoneEntreprise ;

    // @Column(nullable = false,length=191,name = "emailEntreprise")
    // private String emailEntreprise;


    
    
}


