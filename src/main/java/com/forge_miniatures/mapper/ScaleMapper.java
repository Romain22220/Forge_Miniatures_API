package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.ScaleDTO;
import com.forge_miniatures.entity.Scale;

import java.util.List;
import java.util.stream.Collectors;

public class ScaleMapper {

    public static ScaleDTO toScaleDTO(Scale scale) {
        if(scale == null) return null;
        ScaleDTO scaleDTO = new ScaleDTO();
        scaleDTO.setId(scale.getId());
        scaleDTO.setName(scale.getScale());

        return scaleDTO;
    }

    public static Scale toScale(ScaleDTO scaleDTO) {
        if(scaleDTO == null) return null;

        Scale scale = new Scale();
        scale.setId(scaleDTO.getId());
        scale.setScale(scaleDTO.getName());

        return scale;
    }

    public static List<ScaleDTO> toScaleDTO(List<Scale> scales) {
        if(scales == null) return null;
        return scales.stream().map(ScaleMapper::toScaleDTO).collect(Collectors.toList());
    }
}
