package com.forge_miniatures.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String lastName;
    private String pseudo;
    private String email;
    private String phoneNumber;
    private String address;
    private String password;
}
