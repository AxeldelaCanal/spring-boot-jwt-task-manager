package com.axel.taskmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.axel.taskmanager.models.Task;
import com.axel.taskmanager.models.User;
import com.axel.taskmanager.repository.TaskRepository;
import com.axel.taskmanager.repository.UserRepository;
import com.axel.taskmanager.security.services.UserDetailsImpl;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier frontend
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    UserRepository userRepository;

    // Obtener TODAS las tareas del usuario logueado
    @GetMapping
    public List<Task> getAllTasks() {
        Long userId = getCurrentUserId();
        return taskRepository.findByUserId(userId);
    }

    // Crear una tarea nueva para el usuario logueado
    @PostMapping
    public Task createTask(@RequestBody Task taskRequest) {
        Long userId = getCurrentUserId();
        User user = userRepository.findById(userId).orElseThrow();

        Task newTask = new Task(taskRequest.getTitle(), taskRequest.getDescription(), user);
        return taskRepository.save(newTask);
    }

    // Método auxiliar para sacar el ID del usuario del Token
    private Long getCurrentUserId() {
        UserDetailsImpl userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails.getId();
    }
}