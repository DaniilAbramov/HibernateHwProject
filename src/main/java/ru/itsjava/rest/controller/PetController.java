package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.rest.controller.dto.PetDto;
import ru.itsjava.service.PetService;

@Controller
@AllArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping("/pets")
    public String getPetsList(Model model) {
        model.addAttribute("pets", petService.getAllPet());
        return "pets-list";
    }

    @GetMapping("/pets/{id}/edit")
    public String editPet(@PathVariable("id") String id, Model model) {
        PetDto dto = PetDto.toDto(petService.printPetById(Long.parseLong(id)));
        model.addAttribute("petDto", dto);
        return "pets-edit";
    }

    @PostMapping("/pets/{id}/edit")
    public String editPet(PetDto petDto) {
        petService.save(PetDto.toDomainObject(petDto));
        return "redirect:/";
    }
}
