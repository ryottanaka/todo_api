package com.example.todo.api.controller.resourses.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class TodoResponse {
    private final Integer id;
    private final String title;
    private final String detail;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private final LocalDate deadline;
    @JsonProperty("is_completed")
    private final String isCompleted;
    @JsonProperty("register_date")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private final LocalDate registerDate;
    @JsonProperty("update_date")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private final LocalDate updateDate;
}
