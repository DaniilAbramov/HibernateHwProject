package ru.itsjava.service;

import ru.itsjava.domain.Pet;

import java.util.List;

public interface PetService {
    void createPet(Pet pet);

    Pet printPetById(long id);

    List<Pet> getAllPet();

    void save(Pet pet);

}
