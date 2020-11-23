package ru.itsjava.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.repository.PetDao;

@AllArgsConstructor
@Service
public class PetServiceImpl implements PetService {
    private final PetDao petDao;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public void printPetById(long id) {
        System.out.println(petDao.getById(id));
    }
}
