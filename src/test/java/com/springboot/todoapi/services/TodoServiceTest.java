package com.springboot.todoapi.services;

import com.springboot.todoapi.models.Todo;
import com.springboot.todoapi.repository.TodoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
public class TodoServiceTest {

    @MockBean
    private TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @TestConfiguration
    static class TodoServiceContextConfiguration {
        @Bean
        public TodoService todoService(){
            return new TodoService();
        }
    }

    @Test
    public void whenFindAll_ReturnTodoList(){
        // Mockup
        Todo todo1 = new Todo("1","title 1","description 1");
        Todo todo2 = new Todo("2","title 2","description 2");
        List<Todo> data = Arrays.asList(todo1, todo2);

        given(todoRepository.findAll()).willReturn(data);
        //
        assertThat(todoService.getAllTodos())
                .hasSize(2)
                .contains(todo1, todo2);
    }
}
