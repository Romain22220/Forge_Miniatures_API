package com.forge_miniatures.service;

import com.forge_miniatures.dto.UserDTO;

public interface UserService {

    UserDTO findUserByPseudo(String pseudo);
    UserDTO findUserByEmail(String email);
    UserDTO findUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
}
