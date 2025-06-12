package com.asadmaiga.todolist.repository;

import com.asadmaiga.todolist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodolistRepository extends JpaRepository<Task,Integer> {}
