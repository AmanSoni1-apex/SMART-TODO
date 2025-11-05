package com.todo.smart_todo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity  //Marks this class as a database table.
@Table(name = "todos")
@Getter  //Lombok creates getter/setter methods automatically.
@Setter
@NoArgsConstructor  // Needed by JPA to create empty objects while fetching data We need to create the empty object because when JPA loads data from the database, it doesn’t use your normal constructor with parameters Think of it like the JPA: “Let me first make an empty box (Todo object), then I’ll put all the data inside it.”
@AllArgsConstructor  //Creates a constructor with all fields.
public class Todo {

    @Id //Primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-generates the ID.
    private Long Id;

    @Column(nullable = false)
    private String title;

    private String description;

    private boolean completed;

}