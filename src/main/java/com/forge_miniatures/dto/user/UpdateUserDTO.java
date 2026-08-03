package com.forge_miniatures.dto.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDTO {

    private String nom;
    private String prenom;
    private String pseudo;
    private String email;
    private String address;
    private String phoneNumber;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
}