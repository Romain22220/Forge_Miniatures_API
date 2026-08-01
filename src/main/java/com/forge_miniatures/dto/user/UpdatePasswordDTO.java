package com.forge_miniatures.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordDTO {
    @NotBlank(message = "Missing your old password")
    private String oldPassword;
    @NotBlank(message = "Missing your new password")
    private String newPassword;
}
