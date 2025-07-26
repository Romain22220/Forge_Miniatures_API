package com.forge_miniatures;

import com.forge_miniatures.entity.User;
import com.forge_miniatures.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;


@DataJpaTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    private User Jean;

    @BeforeEach
    public void setup() {
        Jean = new User(null, "Dupont", "Jean", "jean123", "jean@mail.com", "0612345678", "12 rue de Paris", "pass123");
    }
    /*
        Test permettant de voir si un User est bien sauvegardé
     */
    @Test
    public void testSaveUser(){
        User result = userRepository.save(Jean);
        Assertions.assertNotNull(result.getId());
    }

    /*
        Test permettant de trouver un User existant par son Id
     */
    @Test
    public void testFindUserById(){
        User savedUser = userRepository.save(Jean);
        Long id = savedUser.getId();
        User result = userRepository.findById(id);
        Assertions.assertNotNull(result);
    }

    /*
        Test permettant de vérifier qu'on ne trouve pas un User par un Id non existant
     */
    @Test
    public void testFindUserByIdNotExistant(){
        Long id = 5L;
        User result = userRepository.findById(id);
        Assertions.assertNull(result);

    }

    /*
        Test permettant de trouver un User existant par son adresse email
     */
    @Test
    public void testFindUserByEmail(){
        userRepository.save(Jean);
        User result = userRepository.findByEmail("jean@mail.com");
        Assertions.assertNotNull(result);
    }

    /*
        Test permettant de vérifier qu'une adresse email non présente génère un null
     */
    @Test
    public void testFindUserByEmailNotExistant(){
        User result = userRepository.findByEmail("coco@coco.fr");
        Assertions.assertNull(result);
    }

    /*
        Test de la fonction FindByPseudo :
        > Test avec un pseudo existant
     */
    @Test
    public void testFindUserByPseudoExistant(){
        userRepository.save(Jean);
        User result = userRepository.findByPseudo("jean123");
        Assertions.assertNotNull(result);
    }

    /*
        Test de la fonction FindByPseudo :
        > Test avec un pseudo non existant
     */
    @Test
    public void testFindUserByPseudoNotExistant(){
        userRepository.save(Jean);
        User result = userRepository.findByPseudo("jean124");
        Assertions.assertNull(result);
    }
}
