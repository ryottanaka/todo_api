package com.example.todo.api.controller.resourses.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequest {
    private String title;
    private String detail;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate deadline;
    @JsonProperty("is_completed")
    private String isCompleted;
}
