package com.example.todo.api.infrastructure.repository;

import com.example.todo.api.infrastructure.repository.entity.TodoEntity;
import com.example.todo.api.infrastructure.repository.mapper.TodoMapper;
import com.example.todo.api.service.model.InsertTodoModel;
import com.example.todo.api.service.model.TodoModel;
import com.example.todo.api.service.model.value.IsCompleted;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<TodoModel> getTodoList() {
        List<TodoEntity> entityList = mapper.getTodoList();
        return entityList.stream()
                .map(entity -> new TodoModel(
                        entity.getId(),
                        entity.getTitle(),
                        entity.getDetail(),
                        entity.getDeadline(),
                        IsCompleted.getByFlag(entity.getIsCompleted()),
                        entity.getRegisterDate(),
                        entity.getUpdateDate()
                )).collect(Collectors.toList());
    }

    public int update(TodoModel todo) {
        return mapper.update(new TodoEntity(
                todo.getId(),
                todo.getTitle(),
                todo.getDetail(),
                todo.getDeadline(),
                todo.getIsCompleted().getFlag(),
                todo.getRegisterDate(),
                todo.getUpdateDate()
        ));
    }

    public int delete(Integer id) {
        return mapper.delete(id);
    }
}
