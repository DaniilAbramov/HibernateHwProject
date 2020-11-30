package ru.itsjava.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.itsjava.domain.Email;
import ru.itsjava.repository.EmailRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EmailServiceImpl implements EmailService {
    private final EmailRepository emailRepository;

    @Transactional(readOnly = true)
    @Override
    public Email printById(long id) {
        return emailRepository.getById(id).get();
    }
    @Transactional(readOnly = true)
    @Override
    public List<Email> getAllEmail() {
        return emailRepository.getAllEmail();
    }

}
