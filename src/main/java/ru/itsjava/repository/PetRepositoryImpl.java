package ru.itsjava.repository;

import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Pet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class PetRepositoryImpl implements PetRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Pet save(Pet pet) {
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
    }

    @Override
    public List<Pet> getAllPet() {
        TypedQuery<Pet> query = entityManager.createQuery("select p from Pet p", Pet.class);
        return query.getResultList();
    }

    @Override
    public void updatePet(Pet pet) {
        entityManager.merge(pet);
    }
}
