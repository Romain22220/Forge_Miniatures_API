package com.forge_miniatures.Controller;

import com.forge_miniatures.dto.UserDTO;
import com.forge_miniatures.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDTO));
    }

    @GetMapping
    public ResponseEntity<UserDTO> getUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userService.findUserByEmail(email));
    }
}
