package com.spring.todo.TodoManager.controllers;

import com.spring.todo.TodoManager.models.Todo;
import com.spring.todo.TodoManager.service.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/todos")
public class TodoController {


    Logger logger = LoggerFactory.getLogger(TodoController.class);
   @Autowired
    private TodoService todoService;
   // create random id
   Random random = new Random();

    // ============================== create ============================

    @PostMapping
    public ResponseEntity<Todo> createTodoHandler(@RequestBody Todo todo){
        //___________ here we create exception to understand how to handle exception in spring boot________
//        String str = null;
//        logger.info("{}",str.length()); // so here we find length of string but string is null then its give NullPointerException generate

        // now here we check NumberFormatException
//        Integer.parseInt("23gjdj"); // here we convert in integer but some string is also so it's impossible to convert then give exception

        // create todo
        int id = random.nextInt(999);
        todo.setId(id);

        // create data with system default current date
        Date CurrentDate = new Date();
        logger.info("Current Date: {}",CurrentDate);
        logger.info("todo date {}", todo.getToDoDate());
        todo.setAddedDate(CurrentDate);
        logger.info("Create Todo");

        // call service to create todo
        Todo todo1 = todoService.createTodo(todo);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);
    }

    //===================================  get all todo method =========================================

    @GetMapping
    public ResponseEntity<List <Todo>>getAllTodoHandler(){
       List<Todo> allTodoes = todoService.getAllTodos();
       return new ResponseEntity<>(allTodoes,HttpStatus.OK);
    }

    // ================================= get Single todo ===============================================

    @GetMapping("/{todoId}")
    public ResponseEntity<Todo> getSingleTodoHaler(
            @PathVariable int todoId
    ) throws ParseException {
       Todo todo =  todoService.getTodo(todoId);
       return ResponseEntity.ok(todo);

    }
    // ===================================== for update todo method =======================================

    @PutMapping("/{todoId}")
    public ResponseEntity<Todo>updateTodoHandler(
            @RequestBody Todo todoWithNewDetails,
            @PathVariable int todoId
    ){

       Todo todo =  todoService.updateTodo(todoId,todoWithNewDetails);
        return ResponseEntity.ok(todo);

    }
    //=============================  delete handler=============================
    @DeleteMapping("/{todoId}")
    public ResponseEntity<String> deleteTodo(
            @PathVariable int todoId
    ){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("Todo successfully deleted");

    }
  //   ================================ exception handle method ================================================
 //    +++++++++++++++++++ for NullPointerException ++++++++++++++++++++++++++++
//    @ExceptionHandler(NullPointerException.class)
//    public ResponseEntity<String> NullPointerExceptionHandler(NullPointerException e){
//        System.out.println(e.getMessage());
//        // this message get developer
//        System.out.println("Null Pointer Exception Generated!");
//
//        // this message got client
//        return new ResponseEntity<>("Null Pointer Exception Generated" +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//
//    //+++++++++++++++++++++++++++++++  NumberFormatException ++++++++++++++++++++++++++++++++++
//    @ExceptionHandler(NumberFormatException.class)
//    public ResponseEntity<String> NumberFormatExceptionHandler(NumberFormatException e){
//        System.out.println(e.getMessage());
//
//        System.out.println("Number Formate Exception generated! ");
//
//        return new ResponseEntity<>("Number Format Exception generated"+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
//    }

  //  +++++++++++++++++++++++++++++++++++++++ we used single method to handler exception but most used  is one by one pass +++++++++++++++++++++++++++=
//  // to pass multiple exception in single ExceptionHandler
//    @ExceptionHandler(value = { NullPointerException.class, NumberFormatException.class})
//  public ResponseEntity<String> NullPointerExceptionHandler(Exception e){
//      System.out.println(e.getMessage());
//      // this message get developer
//      System.out.println("Null Pointer Exception Generated!");
//
//      // this message got client
//      return new ResponseEntity<>("Null Pointer Exception Generated" +e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//  }
}
    