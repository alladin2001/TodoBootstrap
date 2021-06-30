package com.example.todobootstrap.controllers;

import com.example.todobootstrap.entity.ToDo;
import com.example.todobootstrap.entity.User;
import com.example.todobootstrap.service.ToDoService;
import com.example.todobootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/todo")
public class ToDoController {

    private final ToDoService toDoService;
    private final UserService userService;

    @Autowired
    public ToDoController(ToDoService toDoService, UserService userService) {
        this.toDoService = toDoService;
        this.userService = userService;
    }

    @GetMapping
    public String createPage(Model model) {
        model.addAttribute("toDo", new ToDo());
        return "todo";
    }

    @PostMapping
    public String add(@AuthenticationPrincipal User user,
                      @ModelAttribute("toDo") @Valid ToDo toDo,
                      BindingResult result,
                      Model model
        ) {

        return todo(user, toDo, result, model);
    }

    @GetMapping("{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("toDo", toDoService.findById(id).get());
        model.addAttribute("id", id);
        return "todo";
    }

    @PostMapping("{id}")
    public String save(@AuthenticationPrincipal User user,
                      @PathVariable(name = "id") Long id,
                      @ModelAttribute("toDo") @Valid ToDo toDo,
                      BindingResult result,
                      Model model
    ) {
        return todo(user, toDo, result, model);
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        toDoService.delete(id);
        return "redirect:/main";
    }

    public String todo(@AuthenticationPrincipal User user,
                       @ModelAttribute("toDo") @Valid ToDo toDo,
                       BindingResult result,
                       Model model) {
        boolean err = false;

        if (toDo.getTargetDate() != null && toDo.getTargetDate().isBefore(LocalDate.now())) {
            model.addAttribute("dateError", "Date must be today or later");
            err = true;
        }

        if (result.hasErrors()) {
            model.addAttribute("error", "Field must be not empty");
            err = true;
        }

        if (err) {
            model.addAttribute("toDo", toDo);
            return "todo";
        }
        toDoService.save(toDo, user);
        return "redirect:/main";
    }
}
