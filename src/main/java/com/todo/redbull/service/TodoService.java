package com.todo.redbull.service;

import com.todo.redbull.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class TodoService {
    ArrayList<Todo> db = new ArrayList<>();

    int counter = 4;

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

    public Todo addTodo(Todo todo){
        todo.setId(counter);
        counter++;
        db.add(todo);
        return todo;
    }

    public Todo updateTodoById(int id, Todo todo){
        int idx = -1;
        for(int i = 0; i < db.size(); i++)  if(id == db.get(i).getId()) idx = i;
        todo.setId(id);
        db.set(idx, todo);
        return todo;
    }

    public String deleteTodoById(Todo todo){
       db.remove(todo);
       return "Removed";
    }

}


