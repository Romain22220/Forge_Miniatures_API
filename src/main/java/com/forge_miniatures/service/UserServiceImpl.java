package com.forge_miniatures.service;

import com.forge_miniatures.dto.UpdatePasswordDTO;
import com.forge_miniatures.dto.UpdateUserDTO;
import com.forge_miniatures.dto.UserDTO;
import com.forge_miniatures.entity.User;
import com.forge_miniatures.mapper.UserMapper;
import com.forge_miniatures.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final static Logger LOGGER = LogManager.getLogger(UserServiceImpl.class);

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


    @Override
    public UpdateUserDTO updateUser(String email, UpdateUserDTO userDTO) {
        //Check if user is already in the database
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        if (userDTO.getPseudo() != null) {
            String oldPseudo = user.getPseudo();
            user.setPseudo(userDTO.getPseudo());
            LOGGER.info("Pseudo updated from {} to {}", oldPseudo, userDTO.getPseudo());
        }
        if (userDTO.getEmail() != null) {
            String oldEmail = user.getEmail();
            user.setEmail(userDTO.getEmail());
            LOGGER.info("Email updated from {} to {}", oldEmail, user.getEmail());
        }
        if (userDTO.getAddress() != null) {
            String oldAddress = user.getAdresse();
            user.setAdresse(userDTO.getAddress());
            LOGGER.info("Address updated from {} to {}", oldAddress, userDTO.getAddress());
        }
        if(userDTO.getPhoneNumber() != null) {
            String oldPhoneNumber = user.getPhoneNumber();
            user.setPhoneNumber(userDTO.getPhoneNumber());
            LOGGER.info("Phone number updated from {} to {}", oldPhoneNumber, user.getPhoneNumber());
        }
        if(userDTO.getBirthday() != null) {
            Date oldBirthday = user.getBirthday();
            user.setBirthday(userDTO.getBirthday());
            LOGGER.info("Birthday updated from {} to {}", oldBirthday, user.getBirthday());
        }
        LOGGER.info("Your profile as bean updated");
        return UserMapper.updateUserDTO(userRepository.save(user));
    }

    @Override
    public UserDTO updatePassword(String email, UpdatePasswordDTO passwordDTO) {
        //Check if user is already in the database
        User user = userRepository.findUserByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));

        //Check if old password matches with the password in database
        if(!passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPassword()))
            throw new IllegalArgumentException("Old password doesn't match");

        user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
        LOGGER.info("Password updated for the user  {}", user.getEmail());
        return UserMapper.userDTO(userRepository.save(user));
    }
}
