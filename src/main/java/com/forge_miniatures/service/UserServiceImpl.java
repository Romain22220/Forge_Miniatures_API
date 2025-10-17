package com.forge_miniatures.service;

import com.forge_miniatures.dto.UserDTO;
import com.forge_miniatures.entity.User;
import com.forge_miniatures.mapper.UserMapper;
import com.forge_miniatures.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO findUserByPseudo(String pseudo) {
        return null;
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        return UserMapper.userDTO(user);
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
        if(userRepository.existsByPseudo(userDTO.getPseudo()))
            throw new IllegalArgumentException("Pseudo already exists, please select another one !");
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        return UserMapper.userDTO(userRepository.save(user));
    }
}
