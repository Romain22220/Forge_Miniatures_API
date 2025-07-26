package com.forge_miniatures.service;

import com.forge_miniatures.dto.ScaleDTO;
import com.forge_miniatures.entity.Scale;

import java.util.List;

public interface ScaleService {
    ScaleDTO createScale(ScaleDTO scaleDTO);
    ScaleDTO updateScale(ScaleDTO scaleDTO);
    ScaleDTO getScaleById(Long id);
    List<ScaleDTO> getAllScales();
    void deleteScaleById(Long id);
}
