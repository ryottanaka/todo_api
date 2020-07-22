package com.example.todo.api.infrastructure.repository.mapper;

import com.example.todo.api.infrastructure.repository.entity.TodoEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    void insert(TodoEntity entity);

    List<TodoEntity> getTodoList();

    int update(TodoEntity entity);
}
