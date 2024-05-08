package com.example.backend_task.post;

import com.example.backend_task.member.Member;

import java.time.YearMonth;
import java.util.*;

import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

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

    public List<Post> findAll() {
        return posts.values().stream().toList();
    }


    public Optional<Post> findById(Long id) {
        return Optional.ofNullable(posts.get(id));
    }


}