package com.asadmaiga.todolist.services;

import com.asadmaiga.todolist.models.Task;
import com.asadmaiga.todolist.repository.TodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodolistService
{
    private final TodolistRepository todolistRepository;

    @Autowired
    public TodolistService(TodolistRepository todolistRepository)
    {
        this.todolistRepository = todolistRepository;
    }

    public Task save(Task todolist)
    {
        return todolistRepository.save(todolist);
    }

    public List<Task> findAllTasks()
    {
        return todolistRepository.findAll();
    }

    public Task findById(Integer id)
    {
        return todolistRepository.findById(id).orElse(null);
    }

    public Task updateTask(Integer id, Task todolist)
    {
        Task isExists = todolistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        isExists.setTitle(todolist.getTitle());
        isExists.setDescription(todolist.getDescription());
        isExists.setCompleted(todolist.isCompleted());

        return todolistRepository.save(isExists);
    }

    public void delete(Integer id) {
    }
}
