package com.example.todobootstrap.controllers;

import com.example.todobootstrap.entity.User;
import com.example.todobootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registration() {
        return "registration";
    }

    @PostMapping
    public String addUser(@RequestParam(name = "password2") String password2, @Valid User user, BindingResult result, Model model) {
        boolean err = false;

        if (user.getUsername().isEmpty()) {
            model.addAttribute("usernameError", "Username must be not empty");
            err = true;
        }
        if (user.getPassword().isEmpty()) {
            model.addAttribute("passwordError", "Password must be not empty");
            err = true;
        }

        if (password2.isEmpty()) {
            model.addAttribute("password2Error", "Confirm password must be not empty");
            err = true;
        }

        if (!user.getPassword().isEmpty() && !password2.isEmpty()) {
            if (!user.getPassword().equals(password2)) {
                model.addAttribute("password2Error", "Confirm password must be not different with password");
                err = true;
            }
        }

        if (result.hasErrors() || err) {
            model.addAttribute("message", "Error!!!");
            return "registration";
        }
        if(!userService.addUser(user)) {
            model.addAttribute("message", "User exist!!!");
            return "registration";
        }
        return "redirect:/login";
    }
}
