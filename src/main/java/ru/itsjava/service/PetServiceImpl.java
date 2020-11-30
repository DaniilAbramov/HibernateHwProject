package ru.itsjava.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Pet;
import ru.itsjava.repository.PetRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

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
}

