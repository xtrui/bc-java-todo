package com.oocl.todo;


import com.oocl.todo.entity.Todo;
import com.oocl.todo.repository.TodoRepository;
import com.oocl.todo.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

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
}
