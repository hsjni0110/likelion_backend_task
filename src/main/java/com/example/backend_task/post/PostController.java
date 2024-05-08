package com.example.backend_task.post;

import com.example.backend_task.auth.Auth;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDate;

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
    // 게시글 수정
    @PutMapping("/posts/{postId}")
    public void update(
            @Auth Long memberId,
            @PathVariable("postId") Long postId,
            @RequestBody PostUpdateRequest request
    ) {
        postService.update(request.title(), request.content(),postId, memberId, request.date());
    }

    //게시글 삭제
    @DeleteMapping("/posts/{postId}")
    public void delete(
            @Auth Long userId,
            @PathVariable("postId") Long postId
    ){
        postService.delete(postId,userId);
    }
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostResponse> getPost(
            @PathVariable Long postId
    ) {
        PostResponse post = postService.getPostById(postId);
        return ResponseEntity.ok(post);
    }
}
