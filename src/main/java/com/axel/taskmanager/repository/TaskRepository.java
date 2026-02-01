package com.axel.taskmanager.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.axel.taskmanager.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByUserId(Long userId);
}