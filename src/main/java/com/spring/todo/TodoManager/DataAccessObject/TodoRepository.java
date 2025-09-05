package com.spring.todo.TodoManager.DataAccessObject;

import com.spring.todo.TodoManager.models.Todo;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TodoRepository extends JpaRepository<Todo,Integer> {


}
