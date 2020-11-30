package ru.itsjava.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itsjava.rest.controller.dto.UserDto;
import ru.itsjava.service.UserService;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public String getUserList(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users-list";
    }

    @GetMapping("/users/{id}/edit")
    public String editUser(@PathVariable("id") String id, Model model) {
        UserDto dto = UserDto.toDto(userService.printUserById(Long.parseLong(id)));
        model.addAttribute("userDto", dto);
        return "users-edit";
    }

    @PostMapping("/users/{id}/edit")
    public String editUser(UserDto userDto) {
        userService.createUser(UserDto.toDomainObject(userDto));
        return "redirect:/";
    }
}
