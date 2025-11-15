package com.todo.smart_todo.service;

import com.todo.smart_todo.entity.*;
import com.todo.smart_todo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private EmotionService emotionService;

    /**
     * Fetch all Todo items.
     */
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    /**
     * Find a Todo by its ID.
     */
    public Optional<Todo> getTodoById(Long id) {// the optional is the kind of special dataType and we use this if
                                                 // something doesnt't exist we can also return the null but it casue
                                                 // the nUllPointerException so to handle that exception we use
                                                 // "optional" and only/majorly used for the single item not for the
                                                 // complete list.
        return todoRepository.findById(id);
    }

    /**
     * Save or update a Todo.
     * Automatically detects emotion from description.
     */
    public Todo saveTodo(Todo todo) {
        if (todo.getDescription() != null && !todo.getDescription().isEmpty()) {
            String emotion = emotionService.analyzeEmotion(todo.getDescription());
            todo.setEmotion(emotion);
        }
        return todoRepository.save(todo);
    }

    /**
     * Delete a Todo by its ID.
     */
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }

    /**
     * Get Todos based on completed status.
     */
    public List<Todo> getTodoByStatus(boolean completed) {
        return todoRepository.findByCompleted(completed);
    }

    /**
     * Search Todos by title keyword.
     */
    public List<Todo> searchTodos(String keyword) {
        return todoRepository.findByTitleContaining(keyword);
    }
}
