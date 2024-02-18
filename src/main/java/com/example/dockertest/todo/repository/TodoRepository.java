package com.example.dockertest.todo.repository;

import com.example.dockertest.todo.entity.Todo;
import com.example.dockertest.todo.repository.search.TodoSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long>, TodoSearch {
}
