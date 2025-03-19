// package com.kadous.gestiondealer.model;

// import java.util.List;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.Table;

// import com.fasterxml.jackson.annotation.JsonIgnore;

// import lombok.AllArgsConstructor;
// import lombok.Data;
// import lombok.EqualsAndHashCode;
// import lombok.NoArgsConstructor;

// @Data
// @NoArgsConstructor
// @AllArgsConstructor
// @EqualsAndHashCode(callSuper = true)
// @Entity
// @Table(name = "t_fonction_user")
// public class Fonctionuser extends AbstractEntity{

//     @Column(nullable = false,length=200,name = "Libellefonction")
//     private String libellefonction;

//     @Column(length=255,name = "Commentairefonct")
//     private String commentairefonct;

//     @OneToMany(fetch = FetchType.EAGER,mappedBy = "fonctionuser")
//     @JsonIgnore
//     private List<Users> users;
// }
