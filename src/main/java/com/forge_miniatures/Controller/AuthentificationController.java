package com.forge_miniatures.Controller;

import com.forge_miniatures.configuration.JwtService;
import com.forge_miniatures.dto.user.LoginRequestDTO;
import com.forge_miniatures.dto.user.LoginResponseDTO;
import com.forge_miniatures.entity.User;
import com.forge_miniatures.exception.InvalidCredentialsException;
import com.forge_miniatures.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthentificationController.class);
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public AuthentificationController(JwtService jwtService, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow(() -> new InvalidCredentialsException("User not found"));

        // On vérifie le mot de passe
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            LOGGER.warn("ERROR with the login or the password is incorrect");
            throw new InvalidCredentialsException("Email ou mot de passe incorrect");
        }

        // On génère le token JWT
        String token = jwtService.generateToken(user.getEmail());
        LOGGER.info("User : {} is sucessfully connected !", user.getEmail());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
