package com.forge_miniatures.service;

import com.forge_miniatures.dto.ArticleDTO;
import com.forge_miniatures.entity.*;
import com.forge_miniatures.mapper.ArticleMapper;
import com.forge_miniatures.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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

        /*
            On regarde si le type est déjà créé ou non
            - Si oui, on le met directement
            - Si non, on le crée.
         */
        Type type = typeRepository.findTypeByName(articleDTO.getTypeName())
                .orElseGet(() ->{
                Type newType = new Type();
                newType.setName(articleDTO.getTypeName());
                newType.setSubtypes(null);
                return typeRepository.save(newType);
                });

        article.setType(type);

        /*
            On regarde si le status est déjà créé ou non
            - Si oui, on le met directement
            - Si non, on le crée.
         */
        Status status = statusRepository.findStatusByStatut(articleDTO.getStatutName())
                .orElseGet(() ->{
                    Status newStatus = new Status();
                    newStatus.setStatut(articleDTO.getStatutName());
                    return statusRepository.save(newStatus);
        });

        article.setStatuts(status);

        /*
            On regarde si la scale est déjà créé ou non
            - Si oui, on la met directement
            - Si non, on la créer.
         */
        Scale scale = scaleRepository.findScaleByScale(articleDTO.getScaleName())
                .orElseGet(()->{
                    Scale newScale = new Scale();
                    newScale.setScale(articleDTO.getScaleName());
                    return scaleRepository.save(newScale);
                });

        article.setScale(scale);

        /*
            On regarde si la référence est déjà créé ou non
            - Si oui, on la met directement
            - Si non, on la crée.
         */
        Reference reference = referenceRepository.findReferenceByName(articleDTO.getReferenceName())
                .orElseGet(()-> {
                    Reference newReference = new Reference();
                    newReference.setName(articleDTO.getReferenceName());
                    return referenceRepository.save(newReference);
                });

        article.setReference(reference);
        article.setDateCreation(new Date());

        if(articleDTO.getDatePublication().before(article.getDateCreation()))
            throw new IllegalArgumentException("La date de publication ne peut pas être inférieure à la date de création.");

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
    @Transactional
    public void deleteArticleById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found with id " + id));
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
