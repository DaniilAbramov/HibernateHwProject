package ru.itsjava.service;

import ru.itsjava.domain.Pet;

import java.util.List;

public interface PetService {
    Pet printPetById(long id);

    List<Pet> getAllPet();

}
