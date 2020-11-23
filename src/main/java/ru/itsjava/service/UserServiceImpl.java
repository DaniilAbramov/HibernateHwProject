package ru.itsjava.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;
import ru.itsjava.repository.EmailDao;
import ru.itsjava.repository.PetDao;
import ru.itsjava.repository.UserDao;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final EmailDao emailDao;
    private final PetDao petDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    @Override
    public void createUser(User user) {
        userDao.insert(user);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public void printUserById(long id) {
        System.out.println(userDao.getById(id));
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED)
    @Override
    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public void getAllUser(User user, Pet pet, Email email) {
//        userDao.
    }
}
