package com.forge_miniatures.Controller;

import com.forge_miniatures.dto.user.UpdatePasswordDTO;
import com.forge_miniatures.dto.user.UpdateUserDTO;
import com.forge_miniatures.dto.user.UserDTO;
import com.forge_miniatures.service.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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

    @PatchMapping("/me/profile/update")
    public ResponseEntity<UpdateUserDTO> updateUser(Authentication authentication, @RequestBody UpdateUserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(authentication.getName(), userDTO));
    }

    @PatchMapping("/me/password/reset")
    public ResponseEntity<UserDTO> updatePassword(Authentication authentication, @RequestBody @Valid UpdatePasswordDTO passwordDTO) {
        return ResponseEntity.ok(userService.updatePassword(authentication.getName(), passwordDTO));
    }
}
