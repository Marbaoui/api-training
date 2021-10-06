package com.springboot.todoapi.services;

import com.springboot.todoapi.models.Todo;
import com.springboot.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    /**
     * Get all todos
     * @return List of todos
     */
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo getById(String id) {
        return todoRepository.findById(id).get();
    }

    public Todo save(Todo todo) {
        return todoRepository.insert(todo);
    }

    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }

//    public Todo updateTodoDetails(String id, Todo newTodo) {
//        for (Todo todo : data) {
//            if (todo.getId().equals(id)){
//                todo.setTitle(newTodo.getTitle());
//                todo.setDescription(newTodo.getDescription());
//                return todo;
//            }
//        }
//        return null;
//    }
}
