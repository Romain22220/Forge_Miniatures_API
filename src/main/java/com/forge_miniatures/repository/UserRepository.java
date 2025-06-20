package com.forge_miniatures.repository;

import com.forge_miniatures.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByPseudo(String pseudo);
    User findByEmail(String pseudo);
}
