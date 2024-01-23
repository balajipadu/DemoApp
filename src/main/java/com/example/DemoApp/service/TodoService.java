package com.example.DemoApp.service;

import com.example.DemoApp.beans.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<>();

    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "balaji", "Learn Angular", new Date()));
        todos.add(new Todo(++idCounter, "balaji", "Learn Springboot", new Date()));
        todos.add(new Todo(++idCounter, "balaji", "Learn MicroServices", new Date()));
    }

    public List<Todo> findAll() {
        System.out.println("After Get TODOs" + todos);
        return todos;
    }

    public Optional<Todo> getById(Long id) {
        var getTodo = todos.stream().filter(todo -> todo.getId() == id).findFirst();
        return getTodo;
    }

    public Optional<Todo> deleteById(Long id) {
        var deleteTodo = todos.stream().filter(todo -> todo.getId() == id).findFirst();
        todos.remove(deleteTodo.get());
        System.out.println("After Delete TODO" + todos);
        return deleteTodo;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == -1) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            todos.remove(deleteById(todo.getId()).get());
            todos.add(todo);
        }
        return todo;
    }
}
