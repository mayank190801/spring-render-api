package com.todo.redbull.service;

import com.todo.redbull.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Service
public class TodoService {
    ArrayList<Todo> db = new ArrayList<>();

    public TodoService(){
        //at the init level, simply put some dummy values in db for su
        db.add(new Todo(1, "demo-1", "demo desc", false));
        db.add(new Todo(2, "demo-2", "demo desc", false));
        db.add(new Todo(3, "demo-3", "demo desc", false));
    }

    public ArrayList<Todo> getAllTodo(){
        return db;
    }
    public Todo getTodoById(String id){
        return db.get(Integer.parseInt(id));
    }
    public String addTodo(Todo todo){
        db.add(todo);
        return "Successfully Added!";
    }
    public String updateTodoById(Todo todo){
        return "updated";
    }
    public String deleteTodoById(Todo todo){
       db.remove(todo);
       return "Removed";
    }

}


