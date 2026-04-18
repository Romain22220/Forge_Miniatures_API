package com.forge_miniatures.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionDTO {
    private Long id;
    private Long userId;
    private String name;
    private String collectionType;

    private Integer articleCount;
    private Double totalCollectionPrice;

    private List<CollectionItemDTO> items;
}
