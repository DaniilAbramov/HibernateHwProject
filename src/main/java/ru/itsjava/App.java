package ru.itsjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.repository.UserDao;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        var context = SpringApplication.run(App.class);
        Email mikeEmail = new Email(1L, "mike@mail.ru");
        Pet mikePet = new Pet(1L, "Snake");
        User mike = new User(1L, "Mike", mikeEmail, mikePet);

        System.out.println("mike.getName() = " + mike.getName());
        UserDao userDao = context.getBean(UserDao.class);
//        System.out.println("userDao.count() = " + userDao.count());

    }
}
