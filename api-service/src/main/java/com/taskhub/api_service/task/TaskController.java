package com.taskhub.api_service.task;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    public record CreateTaskRequest(String title, String description) {}

    @PostMapping
    public ResponseEntity<TaskDto> create(@RequestBody CreateTaskRequest request) {
        TaskDto created = service.createTask(request.title(), request.description());
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> list() {
        return ResponseEntity.ok(service.getAllTasks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTask(id));
    }
}
