package com.example.todobootstrap.service;

import com.example.todobootstrap.entity.ToDo;
import com.example.todobootstrap.entity.User;
import com.example.todobootstrap.repo.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    private final ToDoRepo toDoRepo;

    @Autowired
    public ToDoService(ToDoRepo toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    public List<ToDo> findAll() {
        return toDoRepo.findAll();
    }

    public void save(ToDo toDo, User user) {
        toDo.setCreateDate(LocalDate.now());
        toDo.setAuthor(user);
        toDoRepo.save(toDo);
    }

    public List<ToDo> findByUser(User user) {
        return toDoRepo.findByAuthor(user);
    }

    public Optional<ToDo> findById(Long id) {
        return toDoRepo.findById(id);
    }

    public void delete(Long id) {
        toDoRepo.delete(toDoRepo.getById(id));
    }
}
