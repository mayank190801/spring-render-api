package com.todo.redbull.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Todo {
    private Integer id;
    private String heading;
    private String description;
    private Boolean status;
}
