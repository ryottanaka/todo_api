package com.example.todo.api.infrastructure.repository;

import com.example.todo.api.infrastructure.repository.entity.TodoEntity;
import com.example.todo.api.infrastructure.repository.mapper.TodoMapper;
import com.example.todo.api.service.model.InsertTodoModel;
import com.example.todo.api.service.model.value.IsCompleted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TodoRepository {
    private final TodoMapper mapper;

    public void insert(InsertTodoModel todo) {
        mapper.insert(new TodoEntity(
                null,
                todo.getTitle(),
                todo.getDetail().orElse(null),
                todo.getDeadline().orElse(null),
                IsCompleted.INCOMPLETE.getFlag(),
                null,
                null
        ));
    }
}
