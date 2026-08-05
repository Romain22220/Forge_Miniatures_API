package com.forge_miniatures.service.article;

import com.forge_miniatures.dto.article.ArticleDTO;
import com.forge_miniatures.dto.article.ArticlePriceDTO;

import java.util.List;

public interface ArticleService {
    ArticleDTO createArticle(ArticleDTO articleDTO);
    ArticleDTO updateArticle(ArticleDTO articleDTO);
    ArticleDTO findArticleByName(String ArticleName);
    ArticleDTO getArticleById(Long id);
    List<ArticleDTO> getAllArticles();
    void deleteArticleById(Long id);
    List<ArticlePriceDTO> getArticlesPrices(List<Long> articleIds);
    List<ArticleDTO> getAllArticlesByType(String type);
    List<ArticleDTO> getAllArticlesByMarque(String marque);
    List<ArticleDTO> getAllArticlesBySubtype(String subtype);
}
