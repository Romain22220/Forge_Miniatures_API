package com.forge_miniatures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name="t1m_users_usr")
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idt_user")
    private Long id;

    @Column(name="nom_user")
    private String nom;

    @Column(name="prenom_user")
    private String prenom;

    @Column(name="pseudo_user",nullable = false, unique = true)
    private String pseudo;

    @Column(name="mail_user")
    private String email;

    @Column(name="telephone_user")
    private String phoneNumber;

    @Column(name="adresse_user")
    private String adresse;

    @Column(name = "password_user")
    private String password;

    @Column(name = "is_admin")
    private Boolean isAdmin;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String role = isAdmin ? "ROLE_ADMIN" : "ROLE_USER";
        return List.of(new SimpleGrantedAuthority(role));
    }

    @Override
    public String getUsername() {
        return email;
    }
}
