package com.spring.todo.TodoManager.service.impl;

import com.spring.todo.TodoManager.exceptions.ResourceNotFoundException;
import com.spring.todo.TodoManager.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// @Component  // whenever we work on service layer we used @Service annotation
@Service
public class TodoServiceImpl implements com.spring.todo.TodoManager.service.TodoService {

    Logger logger = LoggerFactory.getLogger(TodoServiceImpl.class);
    List<Todo>todos = new ArrayList<>();
    // create todo method
    public Todo createTodo(Todo todo){
        // create..
        todos.add(todo);
        logger.info("Todos {}",this.todos);
        return todo;
    }

    public List<Todo> getAllTodos(){
        return todos;
    }

    public Todo getTodo(int todoId){
        Todo todo= todos.stream().filter(t->todoId==t.getId()).findAny().orElseThrow(()-> new  ResourceNotFoundException("Todo not found with given ID", HttpStatus.NOT_FOUND));
        logger.info("TODO: {}",todo);
        return  todo;
    }

    public Todo updateTodo(int todoId, Todo todo){
        List<Todo>newUpdateList= todos.stream().map(t -> {
            if (t.getId()==todoId){
                // perform update
                t.setTitle(todo.getTitle());
                t.setContent(todo.getContent());
                t.setStatus(todo.getStatus());
                return t;
            }
            else {
                return t;
            }

        }).collect(Collectors.toList());
        todos= newUpdateList;
        todo.setId(todoId);
        return todo;
    }

    // for delete
    public void deleteTodo(int todoId){
        logger.info("Deleting Todo");
        List<Todo>newList =   todos.stream().filter(t->t.getId()!=todoId).collect(Collectors.toList());
        todos = newList;

    }
}
