package com.example.todo.api.service.model.value;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum IsCompleted {
    UN_COMPLETED("0"),
    COMPLETED("1");

    private final String isCompleted;
}
