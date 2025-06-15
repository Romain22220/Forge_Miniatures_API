package com.forge_miniatures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t1m_reference_rfc")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idt_reference")
    private Long id;

    @Column(name="nom_reference")
    private String nom;
}
