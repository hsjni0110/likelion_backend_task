package com.example.backend_task.member;

import com.example.backend_task.common.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Long signup(String username, String password, String name) {
        memberRepository.findByUsername(username)
                .ifPresent(it -> {
                    throw new ConflictException("해당 아이디로 이미 가입한 회원이 있습니다.");
                });
        Member member = new Member(username, password, name);
        return memberRepository.save(member)
                .getId();
    }
}
