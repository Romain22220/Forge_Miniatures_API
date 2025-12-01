package com.forge_miniatures.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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

    private Date birthday;

    @NotBlank(message = "Missing your Password")
    private String password;

    private boolean isAdmin;
}
