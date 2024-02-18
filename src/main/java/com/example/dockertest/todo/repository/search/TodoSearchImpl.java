package com.example.dockertest.todo.repository.search;

import com.example.dockertest.todo.entity.QTodo;
import com.example.dockertest.todo.entity.Todo;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

@Slf4j
public class TodoSearchImpl extends QuerydslRepositorySupport implements TodoSearch {

    public TodoSearchImpl() {
        super(Todo.class);
    }

    @Override
    public Page<Todo> search1() {

        log.info("search1 called............");

        QTodo todo = QTodo.todo;

        JPQLQuery<Todo> query = from(todo);

        query.where(todo.title.contains("1"));

        Pageable pageable = PageRequest.of(1, 10, Sort.by("tno").descending());
        this.getQuerydsl().applyPagination(pageable, query);
        query.fetch();      // 목록 데이터

        query.fetchCount();  // 전체 개수

        return null;
    }
}
