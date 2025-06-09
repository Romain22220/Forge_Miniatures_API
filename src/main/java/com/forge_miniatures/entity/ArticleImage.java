package com.forge_miniatures.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t1m_articles_images_ais")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idt_articles_images_ais")
    private Integer id;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "t1m_idt_article", referencedColumnName = "idt_article"),
            @JoinColumn(name = "t1m_idt_scale", referencedColumnName = "t1m_idt_scale"),
            @JoinColumn(name = "t1m_idt_reference", referencedColumnName = "t1m_idt_reference")
    })
    private Article article;
}

