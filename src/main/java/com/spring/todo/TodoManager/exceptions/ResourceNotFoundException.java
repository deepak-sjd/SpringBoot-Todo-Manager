package com.spring.todo.TodoManager.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResourceNotFoundException extends RuntimeException{

    private String message;
    private HttpStatus status;

    public ResourceNotFoundException(String message, HttpStatus status){
        super(message);
        this.message = message;
        this.status =status;

    }
    public ResourceNotFoundException(){

    }
    @Override
     public String  getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message = message;
    }
    public HttpStatus getStatus(){
        return status;
    }
    public void setStatus(HttpStatus status){
        this.status = status;
    }












}
