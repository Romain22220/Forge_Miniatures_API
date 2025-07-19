package com.forge_miniatures.service;

import com.forge_miniatures.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    ArticleDTO createArticle(ArticleDTO articleDTO);
    ArticleDTO updateArticle(ArticleDTO articleDTO);
    ArticleDTO findArticleByName(String ArticleName);
    List<ArticleDTO> findArticlesByMarque(String marque);
    ArticleDTO getArticleById(Long id);
    List<ArticleDTO> getAllArticles();
    void deleteArticleById(Long id);
}
