package com.forge_miniatures.service;

import com.forge_miniatures.dto.ArticlePriceDTO;
import com.forge_miniatures.entity.Article;
import com.forge_miniatures.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticlePriceService {
    private ArticleRepository articleRepository;
    /*
        Récupération du prix de tous les articles de la collection
     */
    public List<ArticlePriceDTO> getArticlesPrices(List<Long> articleIds) {
        List<Article> articles = articleRepository.findAllById(articleIds);

        return articles.stream()
                .map(article -> new ArticlePriceDTO(article.getId(), article.getPrice()))
                .toList();
    }
}
