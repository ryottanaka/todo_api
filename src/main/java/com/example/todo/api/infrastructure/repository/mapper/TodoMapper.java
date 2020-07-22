package com.example.todo.api.infrastructure.repository.mapper;

import com.example.todo.api.infrastructure.repository.entity.TodoEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodoMapper {
    void insert(TodoEntity entity);
}
