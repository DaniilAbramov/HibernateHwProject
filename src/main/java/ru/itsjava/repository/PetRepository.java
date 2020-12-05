package ru.itsjava.repository;

import ru.itsjava.domain.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepository {

    Pet save(Pet pet);

    Optional<Pet> getById(long id);

    void deleteById(long id);

    List<Pet> getAllPet();

    void updatePet(Pet pet);
}
