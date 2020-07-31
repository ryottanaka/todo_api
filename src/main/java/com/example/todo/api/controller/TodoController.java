package com.example.todo.api.controller;

import com.example.todo.api.controller.exception.ButResponseException;
import com.example.todo.api.controller.resourses.request.TodoNewRequest;
import com.example.todo.api.controller.resourses.request.UpdateRequest;
import com.example.todo.api.controller.resourses.response.ToResponse;
import com.example.todo.api.controller.resourses.response.TodoResponse;
import com.example.todo.api.service.TodoService;
import com.example.todo.api.service.model.InsertTodoModel;
import com.example.todo.api.service.model.TodoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class TodoController {
    private final TodoService service;

    @PostMapping("/todo/new")
    public ToResponse postTodo(@RequestBody @Validated TodoNewRequest request, BindingResult result, DateTimeFormatter formatter) throws ButResponseException {
        service.insert(InsertTodoModel.create(request));
        if (result.hasErrors()) {
            throw new ButResponseException();
        }
        return new ToResponse("ok");
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
    public ToResponse update(@RequestParam Integer id, @Validated @RequestBody UpdateRequest request, BindingResult result) throws Exception {
        service.update(TodoModel.create(id, request));
        if (result.hasErrors()) {
            throw new ButResponseException();
        }
        return new ToResponse("ok");
    }

    @DeleteMapping("/todo/delete")
    public ToResponse delete(@Validated @RequestParam Integer id, BindingResult result) throws ButResponseException {
        service.delete(id);
        if (result.hasErrors()) {
            throw new ButResponseException();
        }
        return new ToResponse("ok");
    }
}
