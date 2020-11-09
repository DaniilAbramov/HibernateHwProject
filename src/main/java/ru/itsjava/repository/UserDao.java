package ru.itsjava.repository;

import ru.itsjava.domain.User;

import java.util.Optional;

public interface UserDao {
//    void count(User user);

    User insert(User user);

    Optional<User> getById(long id);

    void deleteById(long id);

}
