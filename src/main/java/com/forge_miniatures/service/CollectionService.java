package com.forge_miniatures.service;

import com.forge_miniatures.dto.CollectionDTO;
import com.forge_miniatures.dto.CollectionItemResponseDTO;
import com.forge_miniatures.dto.CollectionResponseDTO;
import com.forge_miniatures.entity.Article;
import com.forge_miniatures.mapper.CollectionMapper;
import com.forge_miniatures.repository.ArticleRepository;
import com.forge_miniatures.service.client.CollectionAPIClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CollectionService {
    private final CollectionAPIClient collectionClient;
    private final ArticleRepository articleRepository;

    public CollectionService(CollectionAPIClient collectionClient, ArticleRepository articleRepository) {
        this.collectionClient = collectionClient;
        this.articleRepository = articleRepository;
    }

    public CollectionDTO getCollection(Long userId, Long collectionId) {

        // récupérer collection depuis MyCollectionAPI
        CollectionResponseDTO response =
                collectionClient.getCollection(userId, collectionId);

        if (response == null) {
            throw new RuntimeException("Collection not found");
        }

        // récupérer les ids articles
        List<Long> articleIds = response.getItems()
                .stream()
                .map(CollectionItemResponseDTO::getArticleId)
                .toList();

        // récupérer les prix
        Map<Long, Double> priceMap = articleRepository.findAllById(articleIds)
                .stream()
                .collect(Collectors.toMap(
                        Article::getId,
                        Article::getPrice
                ));

        // mapper + calcul
        return CollectionMapper.toDTO(response, priceMap);
    }
}
