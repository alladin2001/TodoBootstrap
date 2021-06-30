package com.example.todobootstrap.controllers;

import com.example.todobootstrap.entity.User;
import com.example.todobootstrap.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/main")
public class MainController {

    private final ToDoService toDoService;

    @Autowired
    public MainController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @GetMapping
    public String main(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("toDos", toDoService.findByUser(user));
        return "main";
    }
}