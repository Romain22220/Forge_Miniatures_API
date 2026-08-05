package com.forge_miniatures.repository;

import com.forge_miniatures.entity.Article;
import com.forge_miniatures.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article,Long> {
    Article findArticleByNom(String nom);
    Article findArticleById(Long id);
    List<Article> findArticlesByMarque(String marque);
    void deleteArticleById(Long id);

    List<Article> findArticlesByType(Optional<Type> type);
}
