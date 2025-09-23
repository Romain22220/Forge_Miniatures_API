package com.forge_miniatures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="t1m_users_usr")
@AllArgsConstructor
@NoArgsConstructor
public class User {
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
}
