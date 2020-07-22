package com.example.todo.api.service.model.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IsCompleted {
    INCOMPLETE("incomplete", "0"),
    COMPLETED("completed", "1");

    private final String value;
    private final String flag;

}
