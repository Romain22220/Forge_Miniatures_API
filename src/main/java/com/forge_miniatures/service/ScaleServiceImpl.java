package com.forge_miniatures.service;

import com.forge_miniatures.dto.ScaleDTO;
import com.forge_miniatures.entity.Scale;
import com.forge_miniatures.mapper.ScaleMapper;
import com.forge_miniatures.repository.ScaleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScaleServiceImpl implements   ScaleService {
    private final ScaleRepository scaleRepository;

    @Override
    public ScaleDTO createScale(ScaleDTO scaleDTO) {
        Scale scale = ScaleMapper.toScale(scaleDTO);
        if (scale == null)
            throw new  IllegalArgumentException("There is a problem with the scale that you attempted to create");
        return ScaleMapper.toScaleDTO(scaleRepository.save(scale));
    }

    @Override
    public ScaleDTO updateScale(ScaleDTO scaleDTO) {
        return null;
    }

    @Override
    public ScaleDTO getScaleById(Long id) {
        Scale scale = scaleRepository.findScaleById(id);
        if(scale == null){
            throw new EntityNotFoundException("Scale with "+ id + " not found. Please select a real scale. ");
        }
        return ScaleMapper.toScaleDTO(scale);
    }

    @Override
    public List<ScaleDTO> getAllScales() {
        return scaleRepository.findAll().stream().map(ScaleMapper::toScaleDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteScaleById(Long id) {
        if (!scaleRepository.existsById(id)) {
            throw new EntityNotFoundException("Scale with id " + id + " not found. Please select a real ID to delete a scale. ");
        }
        scaleRepository.deleteScaleById(id);

    }
}
