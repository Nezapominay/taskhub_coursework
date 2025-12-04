package com.taskhub.api_service.task;

public record TaskDto(
        Long id,
        String title,
        String description,
        String status
) {
    public static TaskDto from(Task entity) {
        return new TaskDto(
                entity.getId(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus()
        );
    }
}
