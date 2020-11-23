package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.repository.UserDao;
import ru.itsjava.service.UserService;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        var context = SpringApplication.run(App.class);
        Email mikeEmail = new Email(1L, "mike@mail.ru");
        Pet mikePet = new Pet(1L, "Snake");
        User mike = new User(1L, "Mike", mikeEmail, mikePet);
        Email joeEmail = new Email(2L, "joe@mail.ru");
        Pet joePet = new Pet(2L, "Dog");
        User joe = new User(2L, "Joe", joeEmail, joePet);


        System.out.println("mike.getName() = " + mike.getName());
        UserService userDao = context.getBean(UserService.class);
//        System.out.println("userDao.count() = " + userDao.count());
        userDao.createUser(mike);
        userDao.createUser(joe);
        userDao.getAllUser();
    }
}
