package com.forge_miniatures.service;

import com.forge_miniatures.dto.ArticleDTO;
import com.forge_miniatures.entity.Article;
import com.forge_miniatures.mapper.ArticleMapper;
import com.forge_miniatures.repository.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService{

    private final ArticleRepository articleRepository;
    private final ScaleRepository scaleRepository;
    private final ReferenceRepository referenceRepository;
    private final StatusRepository statusRepository;
    private final TypeRepository typeRepository;


    @Override
    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        Article article = ArticleMapper.toArticleEntity(articleDTO);

        // Résolution manuelle des objets si pas gérés dans le mapper
        article.setType(typeRepository.findTypeById(articleDTO.getTypeId()));
        if(article.getType()==null){
            throw new EntityNotFoundException("Type not found");
        }
        article.setStatuts(statusRepository.findStatusById(articleDTO.getStatusId()));
        if(article.getStatuts()==null){
            throw new EntityNotFoundException("Status not found");
        }
        article.setScale(scaleRepository.findScaleById(articleDTO.getScaleId()));
        if(article.getScale()==null){
            throw new EntityNotFoundException("Scale not found");
        }
        article.setReference(referenceRepository.findReferenceById(articleDTO.getReferenceId()));
        if(article.getReference()==null){
            throw new EntityNotFoundException("Reference not found");
        }
        article.setDateCreation(new Date());

        return ArticleMapper.toArticleDTO(articleRepository.save(article));
    }

    @Override
    public ArticleDTO updateArticle(ArticleDTO articleDTO) {
        return null;
    }

    @Override
    public ArticleDTO findArticleByName(String articleName) {
        Article article = articleRepository.findArticleByNom(articleName);
        if (article == null) {
            throw new EntityNotFoundException("Article " + articleName + " not found. Please choose a real article. ");
        }
        return ArticleMapper.toArticleDTO(article);

    }

    @Override
    public List<ArticleDTO> findArticlesByMarque(String marque) {
        List<Article> articles = articleRepository.findArticlesByMarque(marque);
    if (articles == null) {
        throw new EntityNotFoundException("Articles by  " + marque+ " not found. Please choose a real marque. ");
    }
        return articles.stream().map(ArticleMapper::toArticleDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteArticleById(Long id) {
        articleRepository.deleteArticleById(id);
    }

    @Override
    public ArticleDTO getArticleById(Long id) {
        Article article = articleRepository.findArticleById(id);
            if (article == null) {
                throw new EntityNotFoundException("Article with "+ id + " not found. Please select a real article. ");
            }
        return ArticleMapper.toArticleDTO(article);
    }

    @Override
    public List<ArticleDTO> getAllArticles() {
        return articleRepository.findAll().stream().map(ArticleMapper::toArticleDTO).collect(Collectors.toList());
    }
}
