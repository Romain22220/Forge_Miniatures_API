package com.forge_miniatures.service.user;

import com.forge_miniatures.dto.user.UpdatePasswordDTO;
import com.forge_miniatures.dto.user.UpdateUserDTO;
import com.forge_miniatures.dto.user.UserDTO;

public interface UserService {

    UserDTO findUserByPseudo(String pseudo);
    UserDTO findUserByEmail(String email);
    UserDTO findUserById(Long id);
    UserDTO createUser(UserDTO userDTO);
    UpdateUserDTO updateUser(String email, UpdateUserDTO userDTO);
    UserDTO updatePassword(String email, UpdatePasswordDTO passwordDTO);
}
