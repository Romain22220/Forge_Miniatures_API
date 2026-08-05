package com.forge_miniatures.service.article;

import com.forge_miniatures.dto.article.ArticleDTO;
import com.forge_miniatures.dto.article.ArticlePriceDTO;
import com.forge_miniatures.entity.*;
import com.forge_miniatures.mapper.ArticleMapper;
import com.forge_miniatures.repository.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ScaleRepository scaleRepository;
    private final ReferenceRepository referenceRepository;
    private final StatusRepository statusRepository;
    private final TypeRepository typeRepository;
    private final SubtypeRepository subtypeRepository;

    private final static Logger LOGGER = LogManager.getLogger(ArticleServiceImpl.class);


    @Override
    public ArticleDTO createArticle(ArticleDTO articleDTO) {
        LOGGER.info("Creating article...");
        Article article = ArticleMapper.toArticleEntity(articleDTO);

        /*
            On regarde si le type est déjà créé ou non
            - Si oui, on le met directement
            - Si non, on le crée.
         */
        Type type = typeRepository.findTypeByName(articleDTO.getTypeName())
                .orElseGet(() ->{
                    LOGGER.info("Creating new type: {}", articleDTO.getTypeName());
                    Type newType = new Type();
                    newType.setName(articleDTO.getTypeName());
                    newType.setSubtypes(null);
                    LOGGER.info("Saving new type: {}", newType.getName());
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
                    LOGGER.info("Creating new status: {}", articleDTO.getStatutName());
                    Status newStatus = new Status();
                    newStatus.setStatut(articleDTO.getStatutName());
                    LOGGER.info("Saving new status: {}", newStatus.getStatut());
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
                    LOGGER.info("Creating new scale: {}", articleDTO.getScaleName());
                    Scale newScale = new Scale();
                    newScale.setScale(articleDTO.getScaleName());
                    LOGGER.info("Saving new scale: {}", newScale.getScale());
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
                    LOGGER.info("Creating new reference: {}", articleDTO.getReferenceName());
                    Reference newReference = new Reference();
                    newReference.setName(articleDTO.getReferenceName());
                    LOGGER.info("Saving new reference: {}", newReference.getName());
                    return referenceRepository.save(newReference);
                });

        article.setReference(reference);
        article.setDateCreation(new Date());

        if(articleDTO.getDatePublication().before(article.getDateCreation()))
            throw new IllegalArgumentException("La date de publication ne peut pas être inférieure à la date de création.");
        LOGGER.info("Saving article: {}", article.getNom());
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
    @Transactional
    public void deleteArticleById(Long id) {
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Article not found with id " + id));
        articleRepository.deleteArticleById(id);
    }

    @Override
    public List<ArticlePriceDTO> getArticlesPrices(List<Long> articleIds) {
        List<Article> articles = articleRepository.findAllById(articleIds);

        return articles.stream()
                .map(article -> new ArticlePriceDTO(article.getId(), article.getPrice()))
                .toList();
    }

    @Override
    public List<ArticleDTO> getAllArticlesByType(String type) {
        Optional<Type> typeToSearch = typeRepository.findTypeByName(type);
        List<Article> articles = articleRepository.findArticlesByType(typeToSearch);
        return articles.stream().map(ArticleMapper::toArticleDTO).collect(Collectors.toList());
    }

    @Override
    public List<ArticleDTO> getAllArticlesByMarque(String marque) {
        List<Article> articles = articleRepository.findArticlesByMarque(marque);
        if (articles.isEmpty()) {
            LOGGER.warn("Articles not found. Please choose a real brand. ");
            throw new EntityNotFoundException("Articles by brand " + marque + " not found. Please choose a real brand. ");
        }
        LOGGER.info("Collect articles with brand {}", marque);
        return articles.stream().map(ArticleMapper::toArticleDTO).collect(Collectors.toList());
    }

    @Override
    public List<ArticleDTO> getAllArticlesBySubtype(String subtype) {
        Subtype subtypeToSearch = subtypeRepository.findSubtypeByName(subtype)
                .orElseThrow(() ->
                        new EntityNotFoundException("Subtype " + subtype + " not found"));

        List<Article> articles = articleRepository.findByType_SubtypesContains(subtypeToSearch);

        LOGGER.info("{} article(s) found for subtype {}", articles.size(), subtype);
        return articles.stream().map(ArticleMapper::toArticleDTO).toList();
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
