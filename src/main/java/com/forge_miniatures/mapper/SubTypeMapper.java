package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.SubTypeDTO;
import com.forge_miniatures.entity.Subtype;
import com.forge_miniatures.entity.Type;

import java.util.List;
import java.util.stream.Collectors;

public class SubTypeMapper {
    /*
        Fonction permettant de passer d'une entité SubType en SubTypeDTO
     */
    public static SubTypeDTO toSubTypeDTO(Subtype subtype) {
        return new SubTypeDTO(
                subtype.getId(),
                subtype.getNom(),
                subtype.getType() != null ? subtype.getType().getNom() : null,
                subtype.getType() != null ? subtype.getType().getId() : null
        );
    }

    /*
        Fonction permettant de passer d'une liste de SubTypes à la liste de SubTypeDTO
     */
    public static List<SubTypeDTO> toSubTypeDTO(List<Subtype> subtypes) {
        if (subtypes == null) return null;

        return subtypes.stream().map(SubTypeMapper::toSubTypeDTO).collect(Collectors.toList());
    }

    /*
        Fonction permettant de passer d'un SubTypeDTO à l'entité
     */
    public static Subtype toSubTypeEntity(SubTypeDTO subtypeDTO) {

        if (subtypeDTO == null) return null;

        Subtype subtype = new Subtype();
        subtype.setId(subtypeDTO.getId());
        subtype.setNom(subtypeDTO.getName());

        if (subtypeDTO.getTypeId() != null) {
            Type type = new Type();
            type.setId(subtypeDTO.getTypeId());
            subtype.setType(type);
        }
        return subtype;
    }
}
