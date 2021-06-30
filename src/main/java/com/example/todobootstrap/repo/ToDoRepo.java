package com.example.todobootstrap.repo;

import com.example.todobootstrap.entity.ToDo;
import com.example.todobootstrap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepo extends JpaRepository<ToDo, Long> {
    List<ToDo> findByAuthor(User user);

}
