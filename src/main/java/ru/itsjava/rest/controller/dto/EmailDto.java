package ru.itsjava.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Email;

@Data
@AllArgsConstructor
public class EmailDto {
    private final long id;
    private String email;

    public static Email toDomainObject(EmailDto emailDto) {
        return new Email(emailDto.id, emailDto.email);
    }

    public static EmailDto toDto(Email email) {
        return new EmailDto(email.getId(), email.getEmail());
    }
}
