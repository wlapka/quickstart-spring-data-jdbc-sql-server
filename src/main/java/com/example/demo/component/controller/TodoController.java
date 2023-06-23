package com.example.demo.component.controller;

import com.example.demo.model.Todo;
import com.example.demo.modules.service.ITodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final ITodoService todoService;

    @Autowired
    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Todo todo) {
        todoService.create(todo);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> findById(@PathVariable long id) {
        Todo todo = todoService.findById(id);
        return ResponseEntity.ok(todo);
    }

    @GetMapping
    public ResponseEntity<List<Todo>> findAll() {
        List<Todo> todos = todoService.findAll();
        return ResponseEntity.ok(todos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable long id, @RequestBody Todo todo) {
        todo.setId(id);
        todoService.update(todo);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        todoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
