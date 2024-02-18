package com.example.dockertest.todo.controller;

import com.example.dockertest.todo.dto.PageRequestDto;
import com.example.dockertest.todo.dto.PageResponseDto;
import com.example.dockertest.todo.dto.TodoDto;
import com.example.dockertest.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/list")
    public PageResponseDto<TodoDto> getTodo(PageRequestDto request) {
        log.info("getTodo............ request: " + request);
        return todoService.getList(request);
    }

    @GetMapping("/{tno}")
    public TodoDto getTodo(@PathVariable("tno") Long tno) {
        return todoService.get(tno);
    }

    @PostMapping
    public Map<String, Long> create(@RequestBody TodoDto todoDto) {
        return Map.of("create ok", todoService.create(todoDto));
    }

    @PutMapping("/{tno}")
    public Map<String, Long> update(
            @PathVariable("tno") Long tno,
            @RequestBody TodoDto todoDto
    ) {
        todoService.update(tno, todoDto);
        return Map.of("update ok", tno);
    }

    @DeleteMapping("/{tno}")
    public Map<String, Long> delete(@PathVariable("tno") Long tno) {
        todoService.delete(tno);
        return Map.of("delete ok", tno);
    }

}
