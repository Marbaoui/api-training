package com.springboot.todoapi.controllers;

import com.springboot.todoapi.models.Todo;
import com.springboot.todoapi.services.TodoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<List<Todo>> listTodo() {
        List<Todo> result =  todoService.getAllTodos();
        return new ResponseEntity<List<Todo>>(result, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable String id) {
        Todo result = todoService.getById(id);
        return new ResponseEntity<Todo>(result, HttpStatus.OK);
    }

    @PostMapping(value = {"","/"})
    public ResponseEntity<Todo> createNewTodo(@Valid @RequestBody Todo todo){
        Todo result = todoService.save(todo);
        return new ResponseEntity<Todo>(result, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable String id){
        todoService.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value = "/{id}")
    public Todo updateTodo(@PathVariable String id, @RequestBody Todo newTodo){
        return todoService.updateTodoDetails(id,newTodo);
    }
}
