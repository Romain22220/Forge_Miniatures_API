package com.forge_miniatures.dto;

import com.forge_miniatures.entity.Article_Image;
import com.forge_miniatures.entity.Reference;
import com.forge_miniatures.entity.Scale;
import com.forge_miniatures.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDTO {
    private Long id;
    private String nom;
    private String description;
    private List<Article_Image> images;
    private double prix;
    private int quantite;
    private Type type;
    private Scale scale;
    private Reference reference;
}
