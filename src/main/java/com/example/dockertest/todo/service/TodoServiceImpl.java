package com.example.dockertest.todo.service;

import com.example.dockertest.todo.dto.TodoDto;
import com.example.dockertest.todo.entity.Todo;
import com.example.dockertest.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    @Transactional(readOnly = true)
    @Override
    public TodoDto get(Long tno) {
        log.info("get............");
        return todoRepository.findById(tno)
                .map(this::entityToDto)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    public Long create(TodoDto todoDto) {
        log.info("create............");

        Todo todo = this.dtoToEntity(todoDto);
        Todo save = todoRepository.save(todo);
        return save.getTno();
    }

    @Override
    public void update(TodoDto todoDto) {
        log.info("update............");

        Todo todo = this.dtoToEntity(todoDto);
        todo.update(todoDto);
    }

    @Override
    public void delete(Long tno) {
        log.info("delete............");

        todoRepository.deleteById(tno);
    }
}
