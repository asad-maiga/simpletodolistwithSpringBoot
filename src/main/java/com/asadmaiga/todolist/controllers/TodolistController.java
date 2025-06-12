package com.asadmaiga.todolist.controllers;

import com.asadmaiga.todolist.models.Task;
import com.asadmaiga.todolist.services.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodolistController
{
    private final TodolistService todolistService;

    @Autowired
    public TodolistController(TodolistService todolistService)
    {
        this.todolistService =  todolistService;
    }

    @PostMapping("/tasks")
    public Task create(@RequestBody Task todolist)
    {
        return todolistService.save(todolist);
    }

    @GetMapping("tasks")
    public List <Task> findAll()
    {
        return todolistService.findAllTasks();
    }

    @GetMapping("/tasks/{task-id}")
    public Task findById(@PathVariable("task-id") Integer id)
    {
        return todolistService.findById(id);
    }

    @PutMapping("tasks/{task-id}")
    public Task update(
            @PathVariable ("task-id") Integer Id,
            @RequestBody Task todolist
    )
    {
        return todolistService.updateTask(Id,todolist);
    }

    @DeleteMapping("/tasks/{task-id}")
    public void deleteById(@PathVariable("task-id") Integer id)
    {
        todolistService.delete(id);
    }

}
