package com.example.backend_task.member;

import backend.likelion.todos.common.UnAuthorizedException;
import lombok.Getter;

@Getter
public class Member {
    private Long id;
    private String username; //아이디
    private String password; //비번
    private String name; //이름

    public Member(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void login(String password) {
        if (this.password.equals(password)) {
            return;
        }
        throw new UnAuthorizedException("비밀번호가 일치하지 않습니다.");
    }
}
