package com.forge_miniatures.service.reference;

import com.forge_miniatures.dto.reference.ReferenceDTO;

import java.util.List;

public interface ReferenceService {
    ReferenceDTO createReference(ReferenceDTO referenceDTO);
    ReferenceDTO updateReference(ReferenceDTO referenceDTO);
    boolean deleteReference(ReferenceDTO referenceDTO);
    List<ReferenceDTO> findAllReferences();
    ReferenceDTO findReferenceById(Long id);
}
