package com.forge_miniatures.repository;

import com.forge_miniatures.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findUserByPseudo(String pseudo);
    Optional<User> findUserByEmail(String email);
    User findUserById(Long id);
    boolean existsByPseudo(String pseudo);



}
