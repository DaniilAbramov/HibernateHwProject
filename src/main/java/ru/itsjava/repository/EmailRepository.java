package ru.itsjava.repository;

import ru.itsjava.domain.Email;

import java.util.List;
import java.util.Optional;

public interface EmailRepository {
    Email save(Email email);

    Optional<Email> getById(long id);

    void deleteById(long id);

    List<Email> getAllEmail();

    void updateEmail(Email email);
}
