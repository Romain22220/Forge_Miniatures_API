package com.forge_miniatures.service.scale;

import com.forge_miniatures.dto.ScaleDTO;

import java.util.List;

public interface ScaleService {
    ScaleDTO createScale(ScaleDTO scaleDTO);
    ScaleDTO updateScale(ScaleDTO scaleDTO);
    ScaleDTO getScaleById(Long id);
    List<ScaleDTO> getAllScales();
    void deleteScaleById(Long id);
}
