package ru.itsjava.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.repository.PetRepository;

@AllArgsConstructor
@Service
public class PetServiceImpl implements PetService {
    private final PetRepository petRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public void printPetById(long id) {
        System.out.println(petRepository.getById(id));
    }
}
