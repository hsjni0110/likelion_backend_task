package com.example.backend_task.member;

import static org.springframework.http.HttpStatus.CREATED;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/POST")
public class MemberController {

    private final MemberService memberService;


    //회원가입 요청 처리
    @ResponseStatus(CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        memberService.signup(
                request.getUsername(),
                request.getPassword(),
                request.getName());
    }
}
