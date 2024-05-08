package com.example.backend_task.post;

import java.time.LocalDate;
import java.util.Date;

public record PostResponse(
        Long id,
        String title,
        String content,
        Long memberId,
        LocalDate createdDate
) {
}
