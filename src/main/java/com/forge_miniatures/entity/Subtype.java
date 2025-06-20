package com.forge_miniatures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t1m_subtype_sbp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subtype {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idt_subtype")
    private Long id;

    @Column(name="nom_subtype")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "idt_type")
    private Type type;
}
