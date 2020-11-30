package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itsjava.service.PetService;

@Controller
@AllArgsConstructor
public class PetController {
    private final PetService petService;

    @GetMapping("/pets")
    public String getPetsList(Model model){
        model.addAttribute("pets",petService.getAllPet());
        return "pets-list";
    }
}
