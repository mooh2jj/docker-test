package com.example.dockertest.todo.dto;


import lombok.*;

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

    private LocalDate dueDate;

}
