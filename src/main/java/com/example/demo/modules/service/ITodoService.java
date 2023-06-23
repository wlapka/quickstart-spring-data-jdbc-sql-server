package com.example.demo.modules.service;

import com.example.demo.model.Todo;

import java.util.List;

public interface ITodoService {

    void create(Todo todo);

    Todo findById(long id);

    List<Todo> findAll();

    void update(Todo todo);

    void delete(long id);
}