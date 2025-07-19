package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.ContainIdDTO;
import com.forge_miniatures.entity.ContainId;

public class ContainIdMapper {

    public static ContainIdDTO toContainIdDTO(ContainId containId) {
        if(containId == null) return null;

        ContainIdDTO containIdDTO = new ContainIdDTO();
        containIdDTO.setIdtArticle(containId.getIdtArticle());
        containIdDTO.setIdtPanier(containId.getIdtPanier());
        return containIdDTO;
    }

    public static ContainId toContainId(ContainIdDTO containIdDTO) {
        if(containIdDTO == null) return null;
        ContainId containId = new ContainId();
        containId.setIdtArticle(containIdDTO.getIdtArticle());
        containId.setIdtPanier(containIdDTO.getIdtPanier());
        return containId;

    }
}
