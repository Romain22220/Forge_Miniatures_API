package com.forge_miniatures.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // désactive CSRF (utile pour les tests POST en local)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/users/create").permitAll() // rend cette route publique
                        .anyRequest().authenticated() // les autres nécessitent auth
                )
                .httpBasic(Customizer.withDefaults()) // active l'auth basic (optionnel)
                .build();
    }
}
