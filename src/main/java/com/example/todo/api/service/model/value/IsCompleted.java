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

    public static IsCompleted getByFlag(String flag) {
        for (IsCompleted isCompleted : IsCompleted.values()) {
            if (isCompleted.getFlag().equals(flag)) {
                return isCompleted;
            }
        }
        throw new IllegalArgumentException("IsCompleted flag's argument is 0 or 1");
    }

    public static IsCompleted getByValue(String value) {
        for (IsCompleted isCompleted : IsCompleted.values()) {
            if (isCompleted.getValue().equals(value)) {
                return isCompleted;
            }
        }
        throw new IllegalArgumentException("IsCompleted flag's argument is 0 or 1");
    }

}
