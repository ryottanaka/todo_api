package com.example.todo.api.controller.resourses.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TodoNewRequest {
    @Size(min = 1, max = 10)
    @NotNull
    private String title;
    private String detail;
    @Pattern(regexp = "^((19|2[0-9])[0-9]{2})/(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])$")
    private String deadline;
}
