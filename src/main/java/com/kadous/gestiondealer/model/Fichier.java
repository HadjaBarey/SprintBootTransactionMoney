package com.kadous.gestiondealer.model;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;

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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)//Permet de renseigner automatiquement les dates created_at et updated_at
@Table(name = "t_fichier")

public class Fichier {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true,length=20,name = "idfichier")
    private Integer idfichier;

    @Column(nullable = false,name = "datesauvegarde")
    private LocalDate datesauvegarde;

    @Column(length=11,name = "supprimer")
    private Integer supprimer;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "OperationTransaction")
    private OperationTransaction operationTransaction;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "Users")
    private Users users;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updated_at;

    
}


