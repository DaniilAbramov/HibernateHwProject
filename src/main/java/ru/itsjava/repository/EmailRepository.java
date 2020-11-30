package ru.itsjava.repository;

import ru.itsjava.domain.Email;

import java.util.List;
import java.util.Optional;

public interface EmailRepository {
    Email insert(Email email);

    Optional<Email> getById(long id);

    void deleteById(long id);

    List<Email> getAllEmail();
}
