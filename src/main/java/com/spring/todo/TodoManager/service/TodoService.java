package com.spring.todo.TodoManager.service;


import com.spring.todo.TodoManager.models.Todo;

import java.text.ParseException;
import java.util.List;

public interface TodoService {
    public Todo createTodo(Todo todo);
    public List<Todo>getAllTodos();
    public Todo getTodo(int todoId) throws ParseException;
    public Todo updateTodo(int todoId, Todo todo);
    public void deleteTodo(int todoId);

}