package com.example.todobootstrap.entity;


import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate targetDate;

//    @NotEmpty
//    private boolean done;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public ToDo() {
    }

    public ToDo(String description, User user) {
        this.description = description;
        this.author = user;

    }public ToDo(String toDo, LocalDate targetDate ,User user) {
        this.description = toDo;
        this.author = user;
        this.targetDate = targetDate;
    }

    public String getAuthorUsername() {
        return author != null ? author.getUsername() : "<no author>";
    }
}
