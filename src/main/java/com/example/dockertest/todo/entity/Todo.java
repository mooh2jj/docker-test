package com.example.dockertest.todo.entity;

import com.example.dockertest.todo.dto.TodoDto;
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
    public Todo(Long tno, String title, String content, boolean completed, LocalDate dueDate) {
        this.tno = tno;
        this.title = title;
        this.content = content;
        this.completed = completed;
        this.dueDate = dueDate;
    }

    public void update(TodoDto todoDto) {
        this.title = todoDto.getTitle();
        this.content = todoDto.getContent();
        this.completed = todoDto.isCompleted();
        this.dueDate = todoDto.getDueDate();
    }
}
