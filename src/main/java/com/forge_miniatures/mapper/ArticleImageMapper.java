package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.ArticleImageDTO;
import com.forge_miniatures.entity.ArticleImage;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArticleImageMapper {

    public static ArticleImageDTO toArticleImageDTO(ArticleImage articleImage) {
        if(articleImage == null) return null;

        ArticleImageDTO articleImageDTO = new ArticleImageDTO();
        articleImageDTO.setId(articleImage.getId());
        articleImageDTO.setImageURL(articleImage.getImageUrl());

        if(articleImage.getArticle() != null){
            articleImageDTO.setArticleId(articleImage.getArticle().getId());
            articleImageDTO.setArticleName(articleImage.getArticle().getNom());
        }

        return articleImageDTO;
    }

    public static ArticleImage toArticleImage(ArticleImageDTO articleImageDTO) {
        if(articleImageDTO == null) return null;

        ArticleImage articleImage = new ArticleImage();
        articleImage.setId(articleImageDTO.getId());
        articleImage.setImageUrl(articleImageDTO.getImageURL());
        return articleImage;
    }

    public static List<ArticleImageDTO> toArticleImageDTO(List<ArticleImage> articleImageList) {
        if(articleImageList == null) return null;

        return articleImageList.stream()
                .map(ArticleImageMapper::toArticleImageDTO)
                .collect(Collectors.toList());
    }

    public static List<ArticleImage> toArticleImage(List<ArticleImageDTO> articleImageDTOList) {
        if(articleImageDTOList == null) return null;

        return articleImageDTOList.stream()
                .map(ArticleImageMapper::toArticleImage)
                .collect(Collectors.toList());
    }
}
