package com.forge_miniatures.dto.user;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;

    @NotBlank(message = "Missing your Name")
    private String name;

    @NotBlank(message = "Missing your Last Name")
    private String lastName;

    @NotBlank(message = "Missing your Pseudo")
    private String pseudo;

    @NotBlank(message = "Missing your Email")
    private String email;

    private String phoneNumber;

    @NotBlank(message = "Missing your Address")
    private String address;

    private LocalDate birthday;

    @NotBlank(message = "Missing your Password")
    private String password;

    private boolean isAdmin;
}
