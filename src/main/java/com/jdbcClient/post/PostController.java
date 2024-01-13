package com.jdbcClient.post;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> findAll () {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post findById (
            @PathVariable("id") Integer id
    ) {
        return postService.findById(id).orElseThrow(() -> new RuntimeException("post not found"));
    }

    @PostMapping
    public ResponseEntity<?> save (
            @RequestBody Post post
    ) {
        postService.create(post);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("post is created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (
            @PathVariable("id") Integer id,
            @RequestBody Post post
    ) {
        postService.update(post, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("post is updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (
            @PathVariable("id") Integer id
    ) {
        postService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("post is deleted");
    }

}
