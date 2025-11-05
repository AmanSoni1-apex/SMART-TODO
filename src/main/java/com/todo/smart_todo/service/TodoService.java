package com.todo.smart_todo.service;

import com.todo.smart_todo.model.Todo;
import com.todo.smart_todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> getAllTodos() { 
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) { // the optional is the kind of special dataType and we use this if something doesnt't exist we can also return the null but it casue the nUllPointerException so to handle that exception we use "optional" and only/majorly used for the single item not for the complete list.
        return todoRepository.findById(id);
    }

    public Todo saveTodo(Todo todo){
        return todoRepository.save(todo);
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> getTodoByStatus(boolean completed)
    {
        return todoRepository.findByCompleted(completed);
    }

    public List<Todo> searchTodos(String keyword)
    {
        return todoRepository.findByTitleContaining(keyword);
    }

}
