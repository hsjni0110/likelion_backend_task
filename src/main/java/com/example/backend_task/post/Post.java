package com.example.backend_task.post;

import backend.likelion.todos.common.UnAuthorizedException;
import com.example.backend_task.common.NotFoundException;
import com.example.backend_task.member.Member;
import java.time.LocalDate;
import lombok.Getter;
import org.springframework.cglib.core.Local;

@Getter
public class Post {


    private Long id;
    private String title;
    private String content;
    private LocalDate createdDate;
    private Member member;

    private Post(String title, String content, LocalDate createdDate, Member member) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
        this.member = member;
    }

    public static Post of(String title, String content, Member member) {
        return new Post(title, content, LocalDate.now(), member);
    }
    public void validateMember(Member member) {
        if (!this.getMember().equals(member)) {
            throw new UnAuthorizedException("해당 게시글에 대한 권한이 없습니다.");
        }
    }

    public void update(String title, String content, LocalDate createdDate) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }


    public void setId(Long id) {
        this.id = id;
    }
}
