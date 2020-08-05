package com.oocl.todo.controller;

import com.oocl.todo.entity.Todo;
import com.oocl.todo.service.TodoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public Todo getTodo() {
        Todo todo = new Todo(1, "你好", false);
        return todoService.addTodo(todo);
    }
}
