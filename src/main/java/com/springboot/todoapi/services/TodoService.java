package com.springboot.todoapi.services;

import com.springboot.todoapi.error.NotFoundException;
import com.springboot.todoapi.models.Todo;
import com.springboot.todoapi.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

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
        try {
            return todoRepository.findById(id).get();
        } catch (NoSuchElementException ex) {
            throw  new NotFoundException(String.format("No Record with the id [%s] was found in out database", id));
        }
    }

    public Todo save(Todo todo) {
        return todoRepository.insert(todo);
    }

    public void deleteById(String id) {
        todoRepository.deleteById(id);
    }

    public Todo updateTodoDetails(String id, Todo newTodo) {
        Todo todo = todoRepository.findById(id).get();
        if (todo.getId().equals(newTodo.getId())) {
            return todoRepository.save(newTodo);
        }
        else return null;
    }
}
