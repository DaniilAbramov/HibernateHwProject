package ru.itsjava.service;


import ru.itsjava.domain.Email;

import java.util.List;

public interface EmailService {
    void createEmail(Email email);
    Email printById(long id);
    List<Email> getAllEmail();
    void save(Email email);
}
