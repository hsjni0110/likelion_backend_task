package com.example.backend_task.post;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public record PostUpdateRequest (
        String title,
        String content,
        @JsonFormat(pattern = "yyyy-MM-dd") LocalDate date
) {}
