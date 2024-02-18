package com.example.dockertest.todo.repository.search;

import com.example.dockertest.todo.dto.PageRequestDto;
import com.example.dockertest.todo.entity.Todo;
import com.querydsl.jpa.JPQLQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;

import static com.example.dockertest.todo.entity.QTodo.*;

@Slf4j
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> search1(PageRequestDto request) {

        log.info("search1 called............");

        JPQLQuery<Todo> query = from(todo);

        Pageable pageable = PageRequest.of(
                request.getPage()-1,
                request.getSize(),
                Sort.by("tno").descending());

        this.getQuerydsl().applyPagination(pageable, query);

        return PageableExecutionUtils.getPage(query.fetch(), pageable, query::fetchCount);
    }
}
