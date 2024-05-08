package com.example.backend_task.post;

import com.example.backend_task.common.NotFoundException;
import com.example.backend_task.member.Member;
import com.example.backend_task.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public Long save(String title, String content, Long userId) {

        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("사용자 정보가 없습니다."));
        Post post = Post.of(title, content, member);
        return postRepository.save(post).getId();
    }
    public void update(String title, String content, Long userId, Long postId, LocalDate createDate) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("사용자 정보가 없습니다."));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("게시글 정보가 없습니다."));
        post.validateMember(member);
        post.update(title,content, createDate);
    }

    public PostResponse getPostById(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new NotFoundException("게시글 정보가 없습니다."));
        return new PostResponse(post.getId(), post.getTitle(), post.getContent(),
                post.getMember().getId(), post.getCreatedDate());
    }

}
