package com.example.backend_task.post;

import com.example.backend_task.member.Member;
import lombok.Getter;

@Getter
public class Post {


    private Long id;
    private String title;
    private String content;
    private Member member;

    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
