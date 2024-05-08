package com.example.backend_task.post;

import com.fasterxml.jackson.annotation.JsonFormat;

public record PostUpdateRequest (
        String title,
        String content
) {}
