package com.example.backend_task.member;

import static org.springframework.http.HttpStatus.CREATED;

import com.example.backend_task.auth.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/POST")
public class MemberController {

    private final MemberService memberService;
    private final JwtService jwtService;

    //회원가입 요청 처리
    @ResponseStatus(CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody SignupRequest request) {
        memberService.signup(
                request.getUsername(),
                request.getPassword(),
                request.getName());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @RequestBody LoginRequest request
    ) {
        Long memberId = memberService.login(request.username(), request.password());
        String accessToken = jwtService.createToken(memberId);
        return ResponseEntity.ok(new LoginResponse(accessToken));
    }
}
