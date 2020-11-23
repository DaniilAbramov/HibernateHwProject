package ru.itsjava.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.User;
import ru.itsjava.repository.EmailDao;
import ru.itsjava.repository.PetDao;
import ru.itsjava.repository.UserDao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final EntityManager entityManager;

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
    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }
}
