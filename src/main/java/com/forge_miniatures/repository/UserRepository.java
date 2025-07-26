package com.forge_miniatures.repository;

import com.forge_miniatures.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findUserByPseudo(String pseudo);
    User findUserByEmail(String pseudo);
    User findUserById(Long id);



}
