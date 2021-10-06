package com.springboot.todoapi.controllers;

import com.springboot.todoapi.models.Todo;
import com.springboot.todoapi.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping(value = {"","/"})
    public List<Todo> listTodo() {
        return  todoService.getAllTodos();
    }

    @GetMapping(value = "/{id}")
    public Todo getTodoById(@PathVariable String id) {
        return todoService.getById(id);
    }
    @PostMapping(value = {"","/"})
    public Todo createNewTodo(@RequestBody Todo todo){
        return todoService.save(todo);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteTodoById(@PathVariable String id){
        todoService.deleteById(id);
    }

//    @PutMapping(value = "/{id}")
//    public Todo updateTodo(@PathVariable String id, @RequestBody Todo newTodo){
//        return todoService.updateTodoDetails(id,newTodo);
//    }
}
