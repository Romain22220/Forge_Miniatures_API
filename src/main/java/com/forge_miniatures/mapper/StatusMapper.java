package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.StatusDTO;
import com.forge_miniatures.entity.Status;

public class StatusMapper {

    public static StatusDTO toStatusDTO(Status status) {
        if(status == null) return null;

        StatusDTO statusDTO = new StatusDTO();
        statusDTO.setId(status.getId());
        statusDTO.setStatus(status.toString());

        return statusDTO;
    }

    public static Status toStatus(StatusDTO statusDTO) {
        if(statusDTO == null) return null;
        Status status = new Status();
        status.setId(statusDTO.getId());
        status.setStatut(statusDTO.getStatus());

        return status;
    }

}
