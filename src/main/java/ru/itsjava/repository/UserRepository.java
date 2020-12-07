package ru.itsjava.repository;

import ru.itsjava.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    int count();

    User save(User user);

    Optional<User> getById(long id);

    void deleteById(long id);

    List<User> getAllUser();

    void updateUser(User user);

}
