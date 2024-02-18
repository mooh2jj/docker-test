package com.example.dockertest.todo.service;

import com.example.dockertest.todo.dto.PageRequestDto;
import com.example.dockertest.todo.dto.PageResponseDto;
import com.example.dockertest.todo.dto.TodoDto;
import com.example.dockertest.todo.entity.Todo;

public interface TodoService {

    TodoDto get(Long tno);

    Long create(TodoDto todoDto);

    void update(TodoDto todoDto);

    void delete(Long tno);

    PageResponseDto<TodoDto> getList(PageRequestDto request);

    default TodoDto entityToDto(Todo entity) {
        return TodoDto.builder()
                .tno(entity.getTno())
                .title(entity.getTitle())
                .content(entity.getContent())
                .completed(entity.isCompleted())
                .dueDate(entity.getDueDate())
                .build();
    }

    default Todo dtoToEntity(TodoDto dto) {
        return Todo.builder()
                .tno(dto.getTno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .completed(dto.isCompleted())
                .dueDate(dto.getDueDate())
                .build();
    }
}
