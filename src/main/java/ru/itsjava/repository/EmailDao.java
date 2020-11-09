package ru.itsjava.repository;

import ru.itsjava.domain.Email;

import java.util.Optional;

public interface EmailDao {
    Email insert(Email email);

    Optional<Email> getById(long id);

    void deleteById(long id);
}
