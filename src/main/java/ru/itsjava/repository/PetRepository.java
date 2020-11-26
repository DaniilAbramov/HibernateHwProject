package ru.itsjava.repository;

import ru.itsjava.domain.Pet;

import java.util.Optional;

public interface PetRepository {

    Pet insert(Pet pet);

    Optional<Pet> getById(long id);

    void deleteById(long id);
}
