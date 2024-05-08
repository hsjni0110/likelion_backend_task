package com.example.backend_task.common;
public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }
}
