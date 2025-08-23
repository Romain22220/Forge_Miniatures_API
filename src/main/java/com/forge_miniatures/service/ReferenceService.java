package com.forge_miniatures.service;

import com.forge_miniatures.dto.ReferenceDTO;

import java.util.List;

public interface ReferenceService {
    ReferenceDTO createReference(ReferenceDTO referenceDTO);
    ReferenceDTO updateReference(ReferenceDTO referenceDTO);
    ReferenceDTO deleteReference(ReferenceDTO referenceDTO);
    List<ReferenceDTO> findAllReferences();
    ReferenceDTO findReferenceById(Long id);
}
