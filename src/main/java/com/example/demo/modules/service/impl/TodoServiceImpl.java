package com.example.demo.modules.service.impl;

import com.example.demo.model.Todo;
import com.example.demo.modules.dao.ITodoDAO;
import com.example.demo.modules.dao.impl.TodoDAO;
import com.example.demo.modules.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements ITodoService {

    private final ITodoDAO todoDAO;

    @Autowired
    public TodoServiceImpl(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @Override
    public void create(Todo todo) {
        // Perform any necessary business logic here
        todoDAO.create(todo);
    }

    @Override
    public Todo findById(long id) {
        // Perform any necessary business logic here
        return todoDAO.findById(id);
    }

    @Override
    public List<Todo> findAll() {
        // Perform any necessary business logic here
        return todoDAO.findAll();
    }

    @Override
    public void update(Todo todo) {
        // Perform any necessary business logic here
        todoDAO.update(todo);
    }

    @Override
    public void delete(long id) {
        // Perform any necessary business logic here
        todoDAO.delete(id);
    }
}

