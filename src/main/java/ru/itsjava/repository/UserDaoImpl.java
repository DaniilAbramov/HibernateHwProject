package ru.itsjava.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public int count() {
        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList().size();
    }

    @Override
    public User insert(User user) {
        if (user.getId() == 0L) {
            entityManager.persist(user);
            return user;
        }
        return entityManager.merge(user);
    }

    @Override
    public Optional<User> getById(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public void deleteById(long id) {
        User deleteUser = entityManager.find(User.class, id);
        entityManager.remove(deleteUser);
    }


}
