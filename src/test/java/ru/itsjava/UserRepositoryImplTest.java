package ru.itsjava;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.repository.EmailRepositoryImpl;
import ru.itsjava.repository.PetRepositoryImpl;
import ru.itsjava.repository.UserRepositoryImpl;
import ru.itsjava.service.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import({PetServiceImpl.class, PetRepositoryImpl.class, EmailRepositoryImpl.class, EmailServiceImpl.class, UserRepositoryImpl.class, UserServiceImpl.class})
@DisplayName("Test email repository methods")
public class UserRepositoryImplTest {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    PetService petRepository;
    @Autowired
    UserService userRepository;
    @Autowired
    EmailService emailRepository;

    @Test
    @DisplayName("корректно сохраняет")
    public void shouldCorrectSave() {
        Pet reggie = new Pet(0L, "Reggie");
        Email emailVova = new Email(0L, "emailVova@mail.ru");
        User vova = new User(0L, "Vova", emailVova, reggie);
        userRepository.save(vova);
        assertEquals(0L, vova.getId());
    }

    @Test
    @DisplayName("корректно находит по id")
    public void shouldCorrectPrintById() {
        Pet reggie = new Pet(0L, "Reggie");
        Email emailVova = new Email(0L, "emailVova@mail.ru");
        User vova = new User(0L, "Vova", emailVova, reggie);

        userRepository.save(vova);
        assertEquals(0L, vova.getId());
    }

    @Test
    @DisplayName("Должен корректно создавать user")
    public void shouldCorrectCreateUser() {
        Pet reggie = new Pet(0L, "Reggie");
        Email emailVova = new Email(0L, "emailVova@mail.ru");
        User vova = new User(0L, "Vova", emailVova, reggie);
        userRepository.save(vova);
        Pet ronPet = new Pet(1L,"RonPet");
        Email ronEmail = new Email(1L, "ronEmail@mail.ru");
        User ron = new User(1L,"Ron",ronEmail,ronPet);
        userRepository.createUser(ron);
        assertEquals(emailRepository.printById(1), ronEmail);
    }
    @Test
    @DisplayName("должен корректно удалять")
    public void shouldCorrectDeleteUser(){
        Pet reggie = new Pet(0L, "Reggie");
        Email emailVova = new Email(0L, "emailVova@mail.ru");
        User vova = new User(0L, "Vova", emailVova, reggie);

//        Pet ronPet = new Pet(1L,"RonPet");
//        Email ronEmail = new Email(1L, "ronEmail@mail.ru");
//        User ron = new User(1L,"Ron",ronEmail,ronPet);
        userRepository.save(vova);
//        userRepository.save(ron);
        userRepository.deleteUserById(1L);
//        userRepository.getAllUser();
        assertNull(userRepository.printUserById(1L));
    }

}
