package com.oocl.todo.controller;

import com.oocl.todo.entity.Todo;
import com.oocl.todo.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodo() {
        Todo hello = new Todo(0, "hello", false);
        todoService.addTodo(hello);
        return todoService.getTodo();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Todo addTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        todo.setId(id);
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTodo(@PathVariable Integer id) {
        todoService.deleteTodo(id);
    }
}
