package com.example.backend_task.post;

import com.example.backend_task.auth.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    //게시글 등록
    @PostMapping("/posts")
    public ResponseEntity<Void> create(
            @Auth Long userId,
            @RequestBody PostCreateRequest request
    ) {
        Long PostId = postService.save(request.title(), request.content(), userId);
        return ResponseEntity.created(URI.create("/posts/" + PostId)).build();
    }
}
