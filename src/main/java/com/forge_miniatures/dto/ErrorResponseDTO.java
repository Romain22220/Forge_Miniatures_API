package com.forge_miniatures.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDTO {
    private String message;
    private int status;
    private Map<String, String> errors;

    public ErrorResponseDTO(String message, int i) {
        this.message = message;
        this.status = i;
        this.errors = null;
    }
}
