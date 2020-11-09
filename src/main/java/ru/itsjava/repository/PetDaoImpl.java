package ru.itsjava.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class PetDaoImpl implements PetDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pet insert(Pet pet) {
        if (pet.getId() == 0L) {
            entityManager.persist(pet);
            return pet;
        }
        return entityManager.merge(pet);
    }

    @Override
    public Optional<Pet> getById(long id) {
        return Optional.ofNullable(entityManager.find(Pet.class, id));
    }

    @Override
    public void deleteById(long id) {
        Pet deletePet = entityManager.find(Pet.class, id);
        entityManager.remove(deletePet);
        System.out.println("Delete completed");
    }
}
