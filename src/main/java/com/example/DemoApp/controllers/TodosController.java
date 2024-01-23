package com.example.DemoApp.controllers;

import com.example.DemoApp.beans.Todo;
import com.example.DemoApp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class TodosController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{todo}")
    public Todo retrieveTodo(@PathVariable String username, @PathVariable Long todo) {

        return todoService.getById(todo).get();
    }

    @PutMapping("/users/{username}/todos/{todo}")
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.save(todo);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        var createTodo = todoService.save(todo);
        var uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{username}/todos/{todo}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable Long todo) {
        var deleteTodo = todoService.deleteById(todo);
        if (deleteTodo.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
