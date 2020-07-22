package com.example.todo.api.service;

import com.example.todo.api.infrastructure.repository.TodoRepository;
import com.example.todo.api.service.model.InsertTodoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    public void insert(InsertTodoModel todo) {
        repository.insert(todo);
    }
}
