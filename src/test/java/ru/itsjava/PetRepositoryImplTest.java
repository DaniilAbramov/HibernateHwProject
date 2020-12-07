package ru.itsjava;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.repository.*;
import ru.itsjava.service.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Import({PetServiceImpl.class, PetRepositoryImpl.class, EmailRepositoryImpl.class, EmailServiceImpl.class, UserRepositoryImpl.class, UserServiceImpl.class})
@DisplayName("Test pet repository methods")
public class PetRepositoryImplTest {
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
        petRepository.save(reggie);
        assertEquals(0L, reggie.getId());
    }

    @Test
    @DisplayName("корректно находит по id")
    public void shouldCorrectPrintById() {
        Pet reggie = new Pet(0L, "Reggie");
        Email emailVova = new Email(0L, "emailVova@mail.ru");
        User vova = new User(0L, "Vova", emailVova, reggie);

        userRepository.save(vova);
        assertEquals(0L, reggie.getId());
    }

    @Test
    @DisplayName("Должен корректно создавать пета")
    public void shouldCorrectCreatePet() {
        Pet reggie = new Pet(0L, "Reggie");
        Email emailVova = new Email(0L, "emailVova@mail.ru");
        User vova = new User(0L, "Vova", emailVova, reggie);
        userRepository.save(vova);
        Pet ron = new Pet(1L, "Ron");
        petRepository.createPet(ron);
        assertEquals(petRepository.printPetById(1), ron);
    }

}
