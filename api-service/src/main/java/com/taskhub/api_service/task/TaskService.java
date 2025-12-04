package com.taskhub.api_service.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskDto createTask(String title, String description) {
        Task task = new Task(title, description);
        Task saved = repository.save(task);
        return TaskDto.from(saved);
    }

    public List<TaskDto> getAllTasks() {
        return repository.findAll()
                .stream()
                .map(TaskDto::from)
                .toList();
    }

    public TaskDto getTask(Long id) {
        Task task = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        return TaskDto.from(task);
    }
}
