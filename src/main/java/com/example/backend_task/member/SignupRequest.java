package com.example.backend_task.member;

public class SignupRequest {
    private String username;
    private String password;
    private String name;

    public SignupRequest(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }
}
