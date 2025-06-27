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
}
