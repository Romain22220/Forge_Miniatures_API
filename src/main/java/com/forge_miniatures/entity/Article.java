package com.forge_miniatures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="t1m_article_atc")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idt_article")
    private Long id;

    @Column(name="nom_Article")
    private String nom;

    @Column(name="marque_article")
    private String marque;

    @Column(name="description_article")
    private String description;


    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleImage> images;

    @Column(name = "prix_article")
    private double prix;

    @Column(name = "quantite_article")
    private int quantite;

    @Column(name="date_creation")
    private Date dateCreation;

    @Column(name="date_publication")
    private Date datePublication;

    @ManyToOne
    @JoinColumn(name = "idt_type")
    private Type type;

    @ManyToOne
    @JoinColumn(name="status_article")
    private Status statuts;

    @ManyToOne
    @JoinColumn(name = "idt_scale")
    private Scale scale;

    @OneToOne
    @JoinColumn(name = "idt_reference")
    private Reference reference;


}
