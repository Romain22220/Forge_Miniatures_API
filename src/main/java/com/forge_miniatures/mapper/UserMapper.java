package com.forge_miniatures.mapper;

import com.forge_miniatures.dto.UserDTO;
import com.forge_miniatures.entity.User;

public class UserMapper {
    public static UserDTO userDTO(User user){
        return new UserDTO(
                user.getId(),
                user.getPrenom(),
                user.getNom(),
                user.getPseudo(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAdresse(),
                user.getPassword()
        );
    }

    public static User toEntity(UserDTO userDTO){
        if(userDTO == null) return null;

        User user = new User();
        user.setId(userDTO.getId());
        user.setNom(userDTO.getName());
        user.setPseudo(userDTO.getPseudo());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setAdresse(userDTO.getAddress());
        user.setPassword(userDTO.getPassword());

        return user;
    }
}
