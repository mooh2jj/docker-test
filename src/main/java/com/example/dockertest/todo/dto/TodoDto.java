package com.example.dockertest.todo.dto;


import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TodoDto {

    private Long tno;

    private String title;

    private String content;

    private boolean completed;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

}
