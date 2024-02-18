package com.example.dockertest.todo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tno;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 1000)
    private String content;

    private boolean completed;

    @Column(name = "due_date")
    private LocalDate dueDate;

    @Builder
    public Todo(String title, String content, boolean completed, LocalDate dueDate) {
        this.title = title;
        this.content = content;
        this.completed = completed;
        this.dueDate = dueDate;
    }
}
