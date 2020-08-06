package com.oocl.todo;


import com.oocl.todo.entity.Todo;
import com.oocl.todo.repository.TodoRepository;
import com.oocl.todo.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class TodoTest {
    private TodoService todoService;
    private TodoRepository todoRepository = mock(TodoRepository.class);
    private Todo todo;

    @BeforeEach
    void setUp() {
        todo = new Todo(1, "hello", false);
        todoService = new TodoService(todoRepository);
    }

    @Test
    void should_return_todo_list_when_get_todo_given_nothing() {
        //given
        given(todoRepository.findAll()).willReturn(Collections.singletonList(todo));
        //when
        List<Todo> todoList = todoService.getTodo();
        //then
        assertEquals(todo, todoList.get(0));
    }

    @Test
    void should_return_todo_when_add_todo_given_todo() {
        //given
        given(todoRepository.save(any())).willReturn(todo);
        //when
        Todo savedTodo = todoService.addTodo(todo);
        //then
        assertEquals(todo, savedTodo);
    }

    @Test
    void should_return_todo_when_update_given_todo() {
        //given
        given(todoRepository.save(any())).willReturn(todo);
        //when
        Todo updatedTodo = todoService.addTodo(todo);
        //then
        assertEquals(todo, updatedTodo);
    }

    @Test
    void should_return_todo_when_delete_given_id() {
        //given
        //when
        todoService.deleteTodo(1);
        //then
        verify(todoRepository, times(1)).deleteById(1);
    }
}
