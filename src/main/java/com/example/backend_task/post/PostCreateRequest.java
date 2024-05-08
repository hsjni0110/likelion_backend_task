package com.example.backend_task.post;

public record PostCreateRequest(
        String title,
        String content
) {
}
