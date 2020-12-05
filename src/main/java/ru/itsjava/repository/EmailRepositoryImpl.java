package ru.itsjava.repository;

import org.springframework.stereotype.Repository;

import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class EmailRepositoryImpl implements EmailRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Email save(Email email) {
        if (email.getId() == 0L) {
            entityManager.persist(email);
            return email;
        }
        return entityManager.merge(email);
    }

    @Override
    public Optional<Email> getById(long id) {
        return Optional.ofNullable(entityManager.find(Email.class, id));
    }

    @Override
    public void deleteById(long id) {
        Pet deletePet = entityManager.find(Pet.class, id);
        entityManager.remove(deletePet);
    }

    @Override
    public List<Email> getAllEmail() {
        TypedQuery<Email> query = entityManager.createQuery("select e from Email e", Email.class);
        return query.getResultList();
    }

    @Override
    public void updateEmail(Email email) {
        entityManager.merge(email);
    }
}
