package com.asadmaiga.todolist.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Task
{

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            length = 100,
            nullable = false,
            unique = true
    )
    private String title;

    @Column(
            unique = true,
            length = 200
    )
    private String description;
    private boolean isCompleted;

    public Task() {}

    public Task(String title, String description, boolean isCompleted)
    {
        this.title = title;
        this.description = description;
        this.isCompleted = isCompleted;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
