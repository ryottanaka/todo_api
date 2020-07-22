package com.example.todo.api.controller;

import com.example.todo.api.controller.resourses.request.TodoNewRequest;
import com.example.todo.api.controller.resourses.request.UpdateRequest;
import com.example.todo.api.controller.resourses.response.OkResponse;
import com.example.todo.api.controller.resourses.response.TodoResponse;
import com.example.todo.api.service.TodoService;
import com.example.todo.api.service.model.InsertTodoModel;
import com.example.todo.api.service.model.TodoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<TodoResponse> getTodo() {
        return service.getTodoList().stream()
        .map(todo -> new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDetail(),
                todo.getDeadline(),
                todo.getIsCompleted().getValue(),
                todo.getRegisterDate(),
                todo.getUpdateDate()
        ))
        .collect(Collectors.toList());
    }

    @PutMapping("/todo/update")
    public OkResponse update(@RequestParam Integer id, @RequestBody UpdateRequest request) {
        service.update(TodoModel.create(id, request));
        return new OkResponse();
    }

    @DeleteMapping("/todo/delete")
    public OkResponse delete (@RequestParam Integer id) {
        service.delete(id);
        return new OkResponse();
    }
}
