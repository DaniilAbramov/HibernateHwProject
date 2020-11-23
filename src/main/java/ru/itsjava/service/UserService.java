package ru.itsjava.service;

import ru.itsjava.domain.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    void printUserById(long id);

    void deleteUserById(long id);

    List<User> getAllUser();

}
