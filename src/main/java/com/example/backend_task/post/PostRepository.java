package com.example.backend_task.post;

import com.example.backend_task.member.Member;
import java.util.Optional;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PostRepository {

    private final Map<Long, Post> posts = new HashMap<>();
    private Long id = 1L;

    public Post save(Post post) {
        post.setId(id);
        posts.put(id++, post);
        return post;
    }

    public void delete(Post post) { posts.remove(post.getId()); }

    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(posts.get(id));
    }
}