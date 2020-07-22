package com.example.todo.api.controller.resourses.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TodoResponse {
    private final String title;
    private final String detail;
    private final LocalDate deadline;
    @JsonProperty("is_completed")
    private final String isCompleted;
    @JsonProperty("register_date")
    private final LocalDate registerDate;
    @JsonProperty("update_date")
    private final LocalDate updateDate;
}
