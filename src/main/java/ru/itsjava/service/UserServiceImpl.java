package ru.itsjava.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.User;
import ru.itsjava.repository.UserRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public void createUser(User user) {
        userRepository.insert(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User printUserById(long id) {
        return userRepository.getById(id).get();
    }

    @Transactional
    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUser() {
        return userRepository.getAllUser();
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.updateUser(user);
    }
}
