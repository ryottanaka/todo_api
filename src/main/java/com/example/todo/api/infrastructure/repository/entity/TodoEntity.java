package com.example.todo.api.infrastructure.repository.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TodoEntity {
    private final Integer id;
    private final String title;
    private final String detail;
    private final LocalDate deadline;
    private final String isCompleted;
    private final LocalDate registerDate;
    private final LocalDate updateDate;
}
