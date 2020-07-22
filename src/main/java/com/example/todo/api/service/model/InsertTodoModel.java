package com.example.todo.api.service.model;

import com.example.todo.api.controller.resourses.request.TodoNewRequest;
import lombok.Value;

import java.time.LocalDate;
import java.util.Optional;

@Value
public class InsertTodoModel {
    private final String title;
    private final String detail;
    private final LocalDate deadline;

    public Optional<String> getDetail() {
        return Optional.ofNullable(this.detail);
    }
    public Optional<LocalDate> getDeadline() {
        return Optional.ofNullable(this.deadline);
    }

    public static InsertTodoModel create(TodoNewRequest request) {
        return new InsertTodoModel(
                request.getTitle(),
                request.getDetail(),
                request.getDeadline()
        );
    }
}
