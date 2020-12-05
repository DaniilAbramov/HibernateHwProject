package ru.itsjava.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Override
    public void createPet(Pet pet) {
        petRepository.save(pet);
    }

    @Transactional(readOnly = true)
    @Override
    public Pet printPetById(long id) {
        return petRepository.getById(id).get();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Pet> getAllPet() {
        return petRepository.getAllPet();
    }

    @Transactional
    @Override
    public void save(Pet pet) {
        petRepository.updatePet(pet);
    }
}

