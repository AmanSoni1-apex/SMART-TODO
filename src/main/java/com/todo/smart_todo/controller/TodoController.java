package com.todo.smart_todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.todo.smart_todo.service.TodoService;

import jakarta.validation.Valid;

import com.todo.smart_todo.model.Todo;


@RestController
@RequestMapping("/api/todo")
public class TodoController {
    
    @Autowired
    private TodoService todoService;

    // getting all the todo's
    @GetMapping
    public List<Todo> getAllTodos() // This is used when we are dealing with the multiple todo item fetching all the todo's that why we dont this "public List<Todo>...."
    {
        return todoService.getAllTodos();
    }

    // get a todo by its id
 @GetMapping("{id}")
public ResponseEntity<Todo> getTodoByid(@PathVariable Long id) { // we use the "@PathVariable" so the spirng boot automaticcally look at the url ,finds the value inside the {id} and passess it to the method
    return todoService.getTodoById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build()); 
    // Java 8+ lambda features is called a method reference operator, It’s a shortcut to refer to a method without calling it immediately. "Hey Java, whenever you get an input, just use this method to process it — don’t call it right now, just remember it"
}


    @PostMapping
    public Todo saveTodos(@Valid @RequestBody Todo todo)  // The @Valid annotation in Spring Boot is used for input validation — to make sure that the data coming from the client follows the rules
    {    
        return todoService.saveTodo(todo);
    }

    @DeleteMapping("/{id}")  //the {id} part in the URL is the plaeholder and it tell the spring boot this part of the url is the dynamic and it will keep changing which it totally depending upon in which todo we want to make the changes...! 
    public String DeleteTodoByid(@PathVariable Long id)
    {
        todoService.deleteTodoById(id);
       return "The " + id + " was deleted successfully";
    }

    @PutMapping
    public Todo updateTodo(@Valid @RequestBody Todo todo)
    {
        return todoService.saveTodo(todo);
    }


    @GetMapping("/status/{completed}")
    public List<Todo> getTodoByStatus(@PathVariable boolean completed){ // @PathVariable boolean only works with "true"/"false" strings in the URL. If you want more readable values like "completed"/"not", you must accept a String and convert it yourself, because Spring cannot auto-convert arbitrary words to boolean.
        return todoService.getTodoByStatus(completed);
    }

    @GetMapping("/search/{keyword}")
    public List<Todo> searchTodoByKeywords(@PathVariable String keyword)
    {
        return todoService.searchTodos(keyword);
    }


}
