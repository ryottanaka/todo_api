package com.example.todo.api.controller;

import com.example.todo.api.controller.resourses.request.TodoNewRequest;
import com.example.todo.api.controller.resourses.response.OkResponse;
import com.example.todo.api.controller.resourses.response.TodoListResponse;
import com.example.todo.api.service.TodoService;
import com.example.todo.api.service.model.InsertTodoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;

    @PostMapping("/todo/new")
    public OkResponse postTodo(@RequestBody TodoNewRequest request) {
        service.insert(InsertTodoModel.create(request));
        return new OkResponse();
    }

    @GetMapping("/todo")
    public TodoListResponse getTodo() {
        return new TodoListResponse("hoge!!");
    }
}
