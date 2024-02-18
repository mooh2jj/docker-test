package com.example.dockertest.todo.repository.search;

import com.example.dockertest.todo.dto.PageRequestDto;
import com.example.dockertest.todo.entity.Todo;
import org.springframework.data.domain.Page;

public interface TodoSearch {


    Page<Todo> search1(PageRequestDto request);
}
