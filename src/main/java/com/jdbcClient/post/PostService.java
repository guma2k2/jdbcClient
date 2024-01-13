package com.jdbcClient.post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> findAll();

    Optional<Post> findById(Integer id);

    void create(Post post);

    void update(Post post, Integer id);

    void delete(Integer id);

}
