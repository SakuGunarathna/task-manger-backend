package com.taskmanagerbackend.controller;

import com.taskmanagerbackend.model.Task;
import com.taskmanagerbackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/task")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/task/id/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/task/status/{status}")
    public ResponseEntity<List<Task>> getTaskByStatus( @PathVariable Long status) {
        Optional<List<Task>> tasks = taskService.getTaskByStatus(status);
        return tasks.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/task")
    public ResponseEntity<Void> addTask(@RequestBody Task task) {
        taskService.addTask(task);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/task/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable Long id, @RequestBody Task task) {
        taskService.updateTask(id, task);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
