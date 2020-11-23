package ru.itsjava.service;

import ru.itsjava.domain.User;

public interface UserService {
    void createUser(User user);
    void printUserById(long id);
    void deleteUserById(long id);

}
