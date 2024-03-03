package com.todo.redbull.controller;

import com.todo.redbull.entity.Todo;
import com.todo.redbull.service.TodoService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
public class TodoController {

    //REST API
    @Autowired
    private TodoService todoService;


    @GetMapping("/todo")
    public ResponseEntity<ArrayList<Todo>> getAllTodo(){
        return ResponseEntity.ok(todoService.getAllTodo());
    }

    @GetMapping("/todo/freetier")
    public String freeTier(){
        return "hello world!";
    }

    @GetMapping("/todo/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable  String id){
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> addTodo(@Valid @RequestBody Todo todo){
        Todo message = todoService.addTodo(todo);
        return ResponseEntity.status(201).body(message);
    }

    @PutMapping("/todo/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String id,  @Valid @RequestBody Todo todo){
        Todo message = todoService.updateTodoById(Integer.parseInt(id), todo);
        return ResponseEntity.ok(message);
    }

    @DeleteMapping("/todo/{id}")
    public ResponseEntity<String> deleteTodo(@Valid @RequestBody Todo todo){
        String message = todoService.deleteTodoById(todo);
        return ResponseEntity.ok(message);
    }


}


