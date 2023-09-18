package com.taskmanagerbackend.repository;

import com.taskmanagerbackend.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Optional<List<Task>> findByStatusAndUserId(Long status, String userId);
}