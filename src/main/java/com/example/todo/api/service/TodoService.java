package com.example.todo.api.service;

import com.example.todo.api.infrastructure.repository.TodoRepository;
import com.example.todo.api.service.model.InsertTodoModel;
import com.example.todo.api.service.model.TodoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repository;

    public void insert(InsertTodoModel todo) {
        repository.insert(todo);
    }

    public List<TodoModel> getTodoList() {
        return repository.getTodoList();
    }

    public void update(TodoModel todo) {
        repository.update(todo);
    }

    public void delete(Integer id) {
        repository.delete(id);
    }
}
