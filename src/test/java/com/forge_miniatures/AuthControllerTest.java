package com.forge_miniatures;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.forge_miniatures.dto.LoginRequestDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.yml")
public class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testLogin() throws Exception {

        LoginRequestDTO loginRequest = new LoginRequestDTO();

        loginRequest.setEmail("romain.tacon01@gmail.com");
        loginRequest.setPassword("1234");

        // Exécute la requête
        MvcResult result = mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(loginRequest)))
                .andDo(print()) // affiche dans la console la requête et la réponse (utile en debug)
                .andExpect(MockMvcResultMatchers.status().isOk()) // ou isUnauthorized(), selon ton cas
                .andReturn();

        // Assert
        String responseBody = result.getResponse().getContentAsString();
        System.out.println("Réponse brute : " + responseBody);

        // Exemple de vérification sur le contenu
        assertThat(responseBody).isNotEmpty();
    }
}
