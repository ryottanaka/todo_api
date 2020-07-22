package com.example.todo.api.service.model;

import com.example.todo.api.service.model.value.IsCompleted;
import lombok.Value;

import java.time.LocalDate;

@Value
public class TodoModel {
    private final String title;
    private final String detail;
    private final LocalDate deadline;
    private final IsCompleted isCompleted;
    private final LocalDate registerDate;
    private final LocalDate updateDate;
}
