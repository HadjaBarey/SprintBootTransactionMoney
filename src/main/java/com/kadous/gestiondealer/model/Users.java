package com.kadous.gestiondealer.model;

import com.kadous.gestiondealer.token.Token;
import jakarta.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class)//Permet de renseigner automatiquement les dates created_at et updated_at
@Table(name = "users")
public class Users implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private Instant created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updated_at;

    @Column(nullable = false, length = 191, name = "IdentiteAG")
    private String identiteag;

    @Column(nullable = false, length = 191, name = "sexe")
    private String sexe;

    @Column(nullable = false, length = 191, name = "telephone")
    private String telephone;

    @Column(nullable = false, length = 191, name = "RefCNIB")
    private String refcnib;

    @Column(nullable = false, unique = true, length = 191, name = "email")
    private String email;

    @Column(nullable = false, unique = true, length = 191, name = "matricule")
    private String matricule;

    @Column(nullable = false, length = 191, name = "password")
    private String password;

    @Column(nullable = false, name = "Cloturer", length = 11, columnDefinition = "Integer default 0")
    private Integer cloturer;

    @Column(name = "status", length = 11, columnDefinition = "Integer default 0")
    private Integer status;

    // @ManyToOne(cascade = CascadeType.MERGE)
    // @JoinColumn(name = "Fonctionuser")
    // private Fonctionuser fonctionuser;

    @Column(length = 45, name = "Mot2passejava")
    private String mot2passejava;

    // @ManyToMany
    // @JoinTable(
    //     name = "user_permission",
    //     joinColumns = @JoinColumn(name = "user_id"),
    //     inverseJoinColumns = @JoinColumn(name = "permission_id")
    // )
    //private List<Permissions> permissions = new ArrayList<>();

    // @ManyToMany
    // @JoinTable(
    //     name = "user_role",
    //     joinColumns = @JoinColumn(name = "user_id"),
    //     inverseJoinColumns = @JoinColumn(name = "role_id")
    // )
    //private List<Roles> roles = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user")
    private List<Token> tokens;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
