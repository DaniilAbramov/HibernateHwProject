package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.rest.controller.dto.EmailDto;
import ru.itsjava.rest.controller.dto.PetDto;
import ru.itsjava.service.EmailService;

@Controller
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/emails")
    public String getEmailList(Model model) {
        model.addAttribute("emails", emailService.getAllEmail());
        return "emails-list";
    }

    @GetMapping("/emails/{id}/edit")
    public String editEmail(@PathVariable("id") String id, Model model) {
        EmailDto dto = EmailDto.toDto(emailService.printById(Long.parseLong(id)));
        model.addAttribute("emailDto", dto);
        return "emails-edit";
    }

    @PostMapping("/emails/{id}/edit")
    public String editEmail(EmailDto emailDto) {
        emailService.save(EmailDto.toDomainObject(emailDto));
        return "redirect:/";
    }

}
