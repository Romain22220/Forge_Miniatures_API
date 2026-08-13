package com.forge_miniatures.service.client;

import com.forge_miniatures.dto.collection.CollectionDTO;
import com.forge_miniatures.dto.collection.CollectionItemResponseDTO;
import com.forge_miniatures.dto.collection.CollectionResponseDTO;
import com.forge_miniatures.dto.collection.CreateCollectionDTO;
import com.forge_miniatures.entity.Article;
import com.forge_miniatures.entity.User;
import com.forge_miniatures.mapper.CollectionMapper;
import com.forge_miniatures.repository.ArticleRepository;
import com.forge_miniatures.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CollectionService {
    private final CollectionAPIClient collectionClient;
    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public CollectionService(CollectionAPIClient collectionClient, ArticleRepository articleRepository, UserRepository userRepository) {
        this.collectionClient = collectionClient;
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
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

    public List<CollectionDTO> getAllCollections(Authentication authentication) {
        User user = userRepository.findUserByEmail(authentication.getName())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        List<CollectionResponseDTO> responses =
                collectionClient.getAllCollections(user.getId());

        return responses.stream()
                .map(response -> {

                    List<Long> articleIds = response.getItems()
                            .stream()
                            .map(CollectionItemResponseDTO::getArticleId)
                            .toList();

                    Map<Long, Double> priceMap =
                            articleRepository.findAllById(articleIds)
                                    .stream()
                                    .collect(Collectors.toMap(
                                            Article::getId,
                                            Article::getPrice));

                    return CollectionMapper.toDTO(response, priceMap);
                })
                .toList();
    }

    public CollectionDTO createCollection(Authentication authentication, CreateCollectionDTO collectionDTO) {

        User user = userRepository.findUserByEmail(authentication.getName())
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found"));

        return collectionClient.createCollection(
                user.getId(),
                collectionDTO
        );
    }

    public void deleteCollection(Authentication authentication, @Valid CollectionDTO collectionDTO) {
        User user = userRepository.findUserByEmail(authentication.getName())
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found"));
        collectionClient.deleteCollection(user.getId(), collectionDTO.getId());
    }
}
