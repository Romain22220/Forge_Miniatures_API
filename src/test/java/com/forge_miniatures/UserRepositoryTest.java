package com.forge_miniatures;

import com.forge_miniatures.entity.User;
import com.forge_miniatures.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser(){
        User user = new User(null, "Dupont", "Jean", "jean123", "0612345678", "jean@mail.com", "pass123", "12 rue de Paris");
        User result = userRepository.save(user);
        Assertions.assertNotNull(result.getId());
    }

    @Test
    public void testFindUserById(){
        User user = new User(null, "Dupont", "Jean", "jean123", "0612345678", "jean@mail.com", "pass123", "12 rue de Paris");
        userRepository.save(user);
        User result = userRepository.findById(user.getId());
        System.out.println("Le user a pour ID :" + result.getId());
        Assertions.assertNotNull(result);
    }
}
