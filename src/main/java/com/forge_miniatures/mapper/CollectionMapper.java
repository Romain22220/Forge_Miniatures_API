package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.CollectionDTO;
import com.forge_miniatures.dto.CollectionItemDTO;
import com.forge_miniatures.dto.CollectionResponseDTO;

import java.util.List;
import java.util.Map;

public class CollectionMapper {

    public static CollectionDTO toDTO(CollectionResponseDTO response, Map<Long, Double> priceMap) {

        if (response == null) return null;

        CollectionDTO dto = new CollectionDTO();

        dto.setId(response.getId());
        dto.setUserId(response.getUserId());
        dto.setName(response.getName());
        dto.setCollectionType(response.getCollectionType());

        // Mapping items
        List<CollectionItemDTO> items = response.getItems()
                .stream()
                .map(item -> {
                    CollectionItemDTO dtoItem = new CollectionItemDTO();
                    dtoItem.setArticleId(item.getArticleId());
                    dtoItem.setQuantity(item.getQuantity());
                    return dtoItem;
                })
                .toList();

        dto.setItems(items);

        // Calcul nombre d'articles
        dto.setArticleCount(items.size());

        // Calcul prix total
        double total = items.stream()
                .mapToDouble(item -> {
                    Double price = priceMap.get(item.getArticleId());
                    return (price != null ? price : 0.0) * item.getQuantity();
                })
                .sum();

        dto.setTotalCollectionPrice(total);

        return dto;
    }
}
