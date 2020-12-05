package ru.itsjava.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Email;
import ru.itsjava.domain.Pet;
import ru.itsjava.domain.User;

@Data
@AllArgsConstructor
public class UserDto {
    private final long id;
    private String name;
    private String pet;
    private String email;

    public static User toDomainObject(UserDto userDto) {
        return new User(userDto.id, userDto.name, new Email(userDto.id, userDto.email), new Pet(userDto.id, userDto.pet));
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(),user.getPet().getNickname(), user.getEmail().getEmail());
    }
}

