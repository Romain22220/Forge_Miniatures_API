package com.forge_miniatures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forge_miniatures.dto.UserDTO;
import com.forge_miniatures.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void shouldCreateUserWithPassword()throws  Exception {

        UserDTO newUser = new UserDTO();

        newUser.setName("Jimmy");
        newUser.setLastName("Briand");
        newUser.setPseudo("Stark");
        newUser.setEmail("j.stark@gmail.com");
        newUser.setPhoneNumber("0600000000");
        newUser.setPassword("1234");
        newUser.setAddress("toto");

        mockMvc.perform(post("/api/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(newUser)));

        var savedUser = userRepository.findUserByPseudo("Stark").orElseThrow();
        assertNotEquals("1234", savedUser.getPassword());

    }

}
