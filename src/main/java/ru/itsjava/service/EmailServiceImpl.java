package ru.itsjava.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.repository.EmailRepository;

@AllArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;

    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, readOnly = true)
    @Override
    public void printById(long id) {
        System.out.println(emailRepository.getById(id));
    }

}
