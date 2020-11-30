package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itsjava.service.EmailService;

@Controller
@AllArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @GetMapping("/emails")
    public String getEmailList(Model model){
        model.addAttribute("emails",emailService.getAllEmail());
        return "emails-list";
    }

}
