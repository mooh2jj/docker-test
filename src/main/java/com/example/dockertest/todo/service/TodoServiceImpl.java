package com.example.dockertest.todo.service;

import com.example.dockertest.todo.dto.PageRequestDto;
import com.example.dockertest.todo.dto.PageResponseDto;
import com.example.dockertest.todo.dto.TodoDto;
import com.example.dockertest.todo.entity.Todo;
import com.example.dockertest.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        Todo save = todoRepository.save(this.dtoToEntity(todoDto));
        return save.getTno();
    }

    @Override
    public void update(Long tno, TodoDto todoDto) {
        log.info("update............");
        Todo todo = todoRepository.findById(tno)
                .orElseThrow(RuntimeException::new);
        todo.update(todoDto);
    }

    @Override
    public void delete(Long tno) {
        log.info("delete............");

        todoRepository.deleteById(tno);
    }

    @Override
    public PageResponseDto<TodoDto> getList(PageRequestDto request) {
        log.info("getList............");

        Page<Todo> result = todoRepository.search1(request);

        List<TodoDto> content = result.map(this::entityToDto).getContent();
        long total = result.getTotalElements();


        return PageResponseDto.<TodoDto>withAll()
                .dtoList(content)
                .pageRequestDto(request)
                .totalCount(total)
                .build();
    }
}
