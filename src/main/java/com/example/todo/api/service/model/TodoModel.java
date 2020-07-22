package com.example.todo.api.service.model;

import com.example.todo.api.controller.resourses.request.UpdateRequest;
import com.example.todo.api.service.model.value.IsCompleted;
import lombok.Value;

import java.time.LocalDate;

@Value
public class TodoModel {
    private final Integer id;
    private final String title;
    private final String detail;
    private final LocalDate deadline;
    private final IsCompleted isCompleted;
    private final LocalDate registerDate;
    private final LocalDate updateDate;

    public static TodoModel create(Integer id, UpdateRequest request) {
        return new TodoModel(
                id,
                request.getTitle(),
                request.getDetail(),
                request.getDeadline(),
                IsCompleted.getByValue(request.getIsCompleted()),
                null,
                null
        );
    }
}
