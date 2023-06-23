package com.example.demo.modules.dao.impl;

import com.example.demo.model.Todo;
import com.example.demo.modules.dao.ITodoDAO;
import com.example.demo.modules.rowmapper.TodoRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoDAO implements ITodoDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TodoDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void create(Todo todo) {
        String sql = "INSERT INTO todo (description, details, done) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, todo.getDescription(), todo.getDetails(), todo.isDone());
    }

    public Todo findById(long id) {
        String sql = "SELECT * FROM todo WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new TodoRowMapper());
    }

    public List<Todo> findAll() {
        String sql = "SELECT * FROM todo";
        return jdbcTemplate.query(sql, new TodoRowMapper());
    }

    public void update(Todo todo) {
        String sql = "UPDATE todo SET description = ?, details = ?, done = ? WHERE id = ?";
        jdbcTemplate.update(sql, todo.getDescription(), todo.getDetails(), todo.isDone(), todo.getId());
    }

    public void delete(long id) {
        String sql = "DELETE FROM todo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}