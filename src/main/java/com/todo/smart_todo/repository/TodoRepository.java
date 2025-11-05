package com.todo.smart_todo.repository;

import com.todo.smart_todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    // Find all todos that are completed or not
    List<Todo> findByCompleted(boolean completed);

    // Find todos by title (search feature)
    List<Todo> findByTitleContaining(String keyword);
}
