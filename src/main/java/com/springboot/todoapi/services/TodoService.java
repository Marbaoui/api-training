package com.springboot.todoapi.services;

import com.springboot.todoapi.models.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service
public class TodoService {
    private List<Todo> data = new ArrayList<>(Arrays.asList(
                new Todo("1", "firstTodo", "this is my first task"),
                new Todo("2", "SecondTodo", "this is my second task"),
                new Todo("3", "thirdTodo", "this is my third task")
            )
    );

    public List<Todo> getAllTodos() {
        return data;
    }

    public Todo getById(String id) {
        for (Todo todo : data) {
            if (todo.getId().equals(id)){
                return todo;
            }
        }
        return null;
    }

    public boolean save(Todo todo) {
        return data.add(todo);
    }

    public boolean deleteById(String id) {
        for (Todo todo : data) {
            if (todo.getId().equals(id)){
                 data.remove(todo);
                 return true;
            }
        }
        return false;
    }
}
