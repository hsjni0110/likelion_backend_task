package com.example.backend_task.post;

import com.example.backend_task.common.NotFoundException;
import com.example.backend_task.member.Member;
import com.example.backend_task.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public Long save(String title, String content, Long userId) {

        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("사용자 정보가 없습니다."));
        Post post = new Post(title, content, member);
        return postRepository.save(post).getId();
    }
}
