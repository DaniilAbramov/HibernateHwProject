package ru.itsjava.service;


import ru.itsjava.domain.Email;

import java.util.List;

public interface EmailService {
    Email printById(long id);
    List<Email> getAllEmail();
}
