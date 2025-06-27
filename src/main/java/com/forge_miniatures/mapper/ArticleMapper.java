package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.ArticleDTO;
import com.forge_miniatures.entity.Article;
import com.forge_miniatures.entity.ArticleImage;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleMapper {
    public static ArticleDTO toArticleDTO(Article article) {
        return new ArticleDTO(
                article.getId(),
                article.getNom(),
                article.getMarque(),
                article.getDescription(),
                article.getImages() != null
                        ? article.getImages().stream().map(ArticleImage::getImageUrl).collect(Collectors.toList())
                        : List.of(),
                article.getPrix(),
                article.getQuantite(),
                article.getDateCreation(),
                article.getDatePublication(),
                article.getType() != null ? article.getType().getNom() : null,
                article.getStatuts() != null ? article.getStatuts().getStatut() : null,
                article.getScale() != null ? article.getScale().getScale() : null,
                article.getReference() != null ? article.getReference().getNom() : null
        );
    }
}
