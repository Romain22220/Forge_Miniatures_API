package com.forge_miniatures.service;

import com.forge_miniatures.dto.UserDTO;
import com.forge_miniatures.entity.User;
import com.forge_miniatures.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public UserDTO findUserByPseudo(String pseudo) {
        return null;
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        return null;
    }

    @Override
    public UserDTO findUserById(Long id) {
        return null;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        if(user == null)
            throw new  IllegalArgumentException("There is a problem with the user that you attempted to create");
        return UserMapper.userDTO(user);
    }
}
