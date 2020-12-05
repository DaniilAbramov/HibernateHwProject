package ru.itsjava.rest.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Pet;

@Data
@AllArgsConstructor
public class PetDto {
    private final long id;
    private String nickname;

    public static Pet toDomainObject(PetDto petDto) {
        return new Pet(petDto.id, petDto.nickname);
    }

    public static PetDto toDto(Pet pet) {
        return new PetDto(pet.getId(), pet.getNickname());
    }
}
