package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.ReferenceDTO;
import com.forge_miniatures.entity.Reference;

import java.util.List;

public class ReferenceMapper {

    public static ReferenceDTO toReferenceDTO(Reference reference) {
        if(reference == null) return null;
        ReferenceDTO referenceDTO = new ReferenceDTO();
        referenceDTO.setId(reference.getId());
        referenceDTO.setName(reference.getName());

        return referenceDTO;
    }

    public static Reference toReference(ReferenceDTO referenceDTO) {
        if(referenceDTO == null) return null;

        Reference reference = new Reference();
        reference.setId(referenceDTO.getId());
        reference.setName(referenceDTO.getName());
        return reference;
    }

    public static List<ReferenceDTO> toReferenceDTO(List<Reference> references) {
        if(references == null) return null;
        return references.stream().map(ReferenceMapper::toReferenceDTO).toList();
    }
}
