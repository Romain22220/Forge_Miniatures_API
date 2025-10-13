package com.forge_miniatures.Controller;

import com.forge_miniatures.configuration.JwtService;
import com.forge_miniatures.dto.LoginRequestDTO;
import com.forge_miniatures.dto.LoginResponseDTO;
import com.forge_miniatures.entity.User;
import com.forge_miniatures.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthentificationController {

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
        User user = userRepository.findUserByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));

        // On vérifie le mot de passe
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(401).body("Mot de passe invalide");
        }

        // On génère le token JWT
        String token = jwtService.generateToken(user.getEmail());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
