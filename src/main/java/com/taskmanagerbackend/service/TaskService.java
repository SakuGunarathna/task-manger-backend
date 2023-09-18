package com.taskmanagerbackend.service;

import com.taskmanagerbackend.config.JWTUtils;
import com.taskmanagerbackend.model.Task;
import com.taskmanagerbackend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private JWTUtils jwtUtils;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Optional<List<Task>> getTaskByStatus(Long status) {
        String userId = getUserId();
        return taskRepository.findByStatusAndUserId(status, userId);
    }

    public void addTask(Task task) {
        String userId = getUserId();
        task.setUserId(userId);
        taskRepository.save(task);
    }

    public void updateTask(Long id, Task task) {
        Optional<Task> existingTask = taskRepository.findById(id);
        existingTask.ifPresent(t -> {
            t.setTitle(task.getTitle());
            t.setDescription(task.getDescription());
            t.setDueDate(task.getDueDate());
            t.setPriority(task.getPriority());
            taskRepository.save(t);
        });
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    private String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof UsernamePasswordAuthenticationToken jwtAuthentication) {
            String token = (String) jwtAuthentication.getCredentials();
            return jwtUtils.getUserIdFromToken(token);

        } else {
            return "";
        }
    }

}
