package com.example.demo.modules.service;

import com.example.demo.model.Todo;
import com.example.demo.modules.dao.impl.TodoDAO;
import com.example.demo.modules.service.impl.TodoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TodoServiceTest {

    @Mock
    private TodoDAO todoDAO;

    @InjectMocks
    private TodoServiceImpl todoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTodo_ShouldInvokeTodoDAOCreate() {
        Todo todo = new Todo();
        todo.setDescription("Buy groceries");
        todo.setDetails("Milk, eggs, bread");
        todo.setDone(false);

        todoService.create(todo);

        verify(todoDAO, times(1)).create(todo);
    }

    @Test
    void findById_ShouldReturnTodo() {
        Todo todo = new Todo();
        todo.setId(Long.valueOf(1));
        todo.setDescription("Buy groceries");
        todo.setDetails("Milk, eggs, bread");
        todo.setDone(false);

        when(todoDAO.findById(1)).thenReturn(todo);

        Todo result = todoService.findById(1);

        assertEquals(todo, result);
    }

    @Test
    void findAll_ShouldReturnAllTodos() {
        Todo todo1 = new Todo();
        todo1.setId(Long.valueOf(1));
        todo1.setDescription("Buy groceries");
        todo1.setDetails("Milk, eggs, bread");
        todo1.setDone(false);

        Todo todo2 = new Todo();
        todo2.setId(Long.valueOf(2));
        todo2.setDescription("Clean the house");
        todo2.setDetails("Vacuum, dust, mop");
        todo2.setDone(false);

        List<Todo> todos = new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);

        when(todoDAO.findAll()).thenReturn(todos);

        List<Todo> result = todoService.findAll();

        assertEquals(todos, result);
    }

    @Test
    void updateTodo_ShouldInvokeTodoDAOUpdate() {
        Todo todo = new Todo();
        todo.setId(Long.valueOf(1));
        todo.setDescription("Buy groceries");
        todo.setDetails("Milk, eggs, bread");
        todo.setDone(true);

        todoService.update(todo);

        verify(todoDAO, times(1)).update(todo);
    }

    @Test
    void deleteTodo_ShouldInvokeTodoDAODelete() {
        int id = 1;

        todoService.delete(id);

        verify(todoDAO, times(1)).delete(id);
    }
}
