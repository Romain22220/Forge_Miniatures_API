package com.forge_miniatures.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContainDTO {
    private ContainIdDTO id;
    private String shop;
    private String article;
    private int quantity;
}
