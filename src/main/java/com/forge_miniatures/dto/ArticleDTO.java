package com.forge_miniatures.dto;

import com.forge_miniatures.entity.ArticleImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    private Long id;
    private String name;
    private String marque;
    private String description;
    private List<String> images;
    private double price;
    private int quantite;
    private Date dateCreation;
    private Date datePublication;
    private String type;
    private String statut;
    private String scale;
    private String reference;
}
