package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    Article findArticleByName(String nomArticle);
    Article findArticleById(Long id);
    List<Article> findArticlesByMarque(String marque);
    void deleteArticleById(Long id);
}
