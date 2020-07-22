package com.example.todo.api.controller.resourses.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoNewRequest {
    private String title;
    private String detail;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate deadline;
}
