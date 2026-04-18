package com.forge_miniatures.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CollectionItemDTO {
    private Long articleId;
    private Integer quantity;
}
