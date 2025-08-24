package com.forge_miniatures.service;

import com.forge_miniatures.dto.ReferenceDTO;
import com.forge_miniatures.entity.Reference;
import com.forge_miniatures.mapper.ReferenceMapper;
import com.forge_miniatures.repository.ReferenceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReferenceServiceImpl implements ReferenceService {

    private final ReferenceRepository referenceRepository;

    @Override
    public ReferenceDTO createReference(ReferenceDTO referenceDTO) {
        Reference reference = ReferenceMapper.toReference(referenceDTO);
        if (reference == null)
            throw new  IllegalArgumentException("There is a problem with the reference that you attempted to create");
        return ReferenceMapper.toReferenceDTO(referenceRepository.save(reference));
    }

    @Override
    public ReferenceDTO updateReference(ReferenceDTO referenceDTO) {
        return null;
    }

    @Override
    public boolean deleteReference(ReferenceDTO referenceDTO) {
        return true;
    }

    @Override
    public List<ReferenceDTO> findAllReferences() {
        return referenceRepository.findAll().stream().map(ReferenceMapper::toReferenceDTO).collect(Collectors.toList());
    }

    @Override
    public ReferenceDTO findReferenceById(Long id) {
        Reference reference = referenceRepository.findReferenceById(id);
        if(reference == null)
            throw new EntityNotFoundException("Reference with "+ id + " not found. Please select a real Reference. ");

        return ReferenceMapper.toReferenceDTO(reference);
    }
}
