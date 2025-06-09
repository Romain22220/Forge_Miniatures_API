package com.forge_miniatures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name="description_article")
    private String description;

    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ArticleImage> images;

    @Column(name = "prix_article")
    private double prix;

    @Column(name = "quantite_article")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    @ManyToOne
    @JoinColumn(name = "scale_id")
    private Scale scale;

    @ManyToOne
    @JoinColumn(name = "reference_id")
    private Reference reference;


}
