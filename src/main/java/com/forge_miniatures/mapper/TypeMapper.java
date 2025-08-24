package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.SubTypeDTO;
import com.forge_miniatures.dto.TypeDTO;
import com.forge_miniatures.entity.Type;


import java.util.List;
import java.util.stream.Collectors;

public class TypeMapper {

    /*
        Création de la fonction permettant de passer d'une entité Type en TypeDTO
     */
    public static TypeDTO toDTO(Type type) {
    if(type == null) return null;

    List<SubTypeDTO> subTypeDTOs = null;
    // On convertit chaque Subtype en SubTypeDTO
        if (type.getSubtypes() != null) {
            subTypeDTOs = type.getSubtypes().stream().map(SubTypeMapper::toSubTypeDTO).toList();
        }

        List<String> subTypeNames = subTypeDTOs != null
                ? subTypeDTOs.stream().map(SubTypeDTO::getName).collect(Collectors.toList())
                : null;
        return new TypeDTO(
                type.getId(),
                type.getName(),
                subTypeNames
        );
    }

    /*
        Création de la fonction pour passer d'un DTO à l'entité Type
     */
    public static Type toEntity(TypeDTO typeDTO) {
        if(typeDTO == null) return null;

        Type type = new Type();
        type.setId(typeDTO.getId());
        type.setName(typeDTO.getName());
        type.setSubtypes(null);
        return type;
    }
}
