package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.ArticleDTO;
import com.forge_miniatures.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class ArticleMapper {

    /*
        Fonction permettant de mettre l'entité Article vers ArticleDTO
     */
    public static ArticleDTO toArticleDTO(Article article) {

        if (article == null) return null;

        ArticleDTO articleDTO = new ArticleDTO();

        articleDTO.setId(article.getId());
        articleDTO.setName(article.getNom());
        articleDTO.setMarque(article.getMarque());
        articleDTO.setDescription(article.getDescription());
        articleDTO.setQuantite(article.getQuantite());
        articleDTO.setDateCreation(article.getDateCreation());
        articleDTO.setDatePublication(article.getDatePublication());
        articleDTO.setTypeId(article.getType() != null ? article.getType().getId() : null);
        articleDTO.setTypeName(article.getType() != null ? article.getType().getName() : null );
        articleDTO.setStatusId(article.getStatuts() != null ? article.getStatuts().getId() : null);
        articleDTO.setStatutName(article.getStatuts() != null ? article.getStatuts().getStatut() : null);
        articleDTO.setScaleId(article.getScale() != null ? article.getScale().getId() : null);
        articleDTO.setScaleName(article.getScale()!= null ? article.getScale().getScale(): null);
        articleDTO.setReferenceId(article.getReference() != null ? article.getReference().getId() : null);
        articleDTO.setReferenceName(article.getReference() != null ? article.getReference().getName() : null);

        if (article.getImages() != null && !article.getImages().isEmpty()) {
            List<String> imageUrls = article.getImages().stream()
                    .map(ArticleImage::getImageUrl)
                    .collect(Collectors.toList());
            articleDTO.setImages(imageUrls);
        }

        return articleDTO;
    }

    /*
        Fonction permettant de passer du DTO vers Entité
     */
    public static Article toArticleEntity(ArticleDTO articleDTO) {
        if(articleDTO == null) return null;

        Article article = new Article();
        article.setId(articleDTO.getId());
        article.setNom(articleDTO.getName());
        article.setMarque(articleDTO.getMarque());
        article.setDescription(articleDTO.getDescription());
        article.setPrice(articleDTO.getPrice());
        article.setQuantite(articleDTO.getQuantite());
        article.setDateCreation(articleDTO.getDateCreation());
        article.setDatePublication(articleDTO.getDatePublication());

        if(articleDTO.getTypeName() != null) {
            Type type = new Type();
            type.setId(articleDTO.getTypeId());
            article.setType(type);
        }

        if(articleDTO.getStatutName() != null) {
            Status status = new Status();
            status.setId(articleDTO.getStatusId());
            article.setStatuts(status);
        }

        if(articleDTO.getScaleName() != null) {
            Scale scale = new Scale();
            scale.setId(articleDTO.getScaleId());
            article.setScale(scale);
        }

        if(articleDTO.getReferenceName() != null) {
            Reference reference = new Reference();
            reference.setId(articleDTO.getReferenceId());
            article.setReference(reference);
        }

        if(articleDTO.getImages() != null && !articleDTO.getImages().isEmpty()) {
            List<ArticleImage> imageList = articleDTO.getImages()
                    .stream()
                    .map(url -> {
                        ArticleImage articleImage = new ArticleImage();
                        articleImage.setImageUrl(url);
                        return articleImage;
                    }).collect(Collectors.toList());
            article.setImages(imageList);
        }

        return article;
    }

    /*
        Fonction permettant de mettre en list d'entités en list de DTO
     */
    public static List<ArticleDTO> toArticleDTO(List<Article> articles) {
        return articles.stream().map(ArticleMapper::toArticleDTO).collect(Collectors.toList());
    }

}
