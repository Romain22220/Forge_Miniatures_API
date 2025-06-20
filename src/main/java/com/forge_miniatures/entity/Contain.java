package com.forge_miniatures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t1m_contain_ctn")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contain {

    @Id
    @ManyToOne
    @JoinColumn(name="idt_panier")
    private Shop shop;

    @Id
    @ManyToOne
    @JoinColumn(name="idt_article")
    private Article article;

    @Column(name="quantite")
    private int quantite;
}
