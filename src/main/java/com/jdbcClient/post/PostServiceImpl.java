package com.jdbcClient.post;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class PostServiceImpl implements PostService{
    private final JdbcClient jdbcClient;

    public PostServiceImpl(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public List<Post> findAll() {
        var sql = """
                SELECT id,title,slug,date,time_to_read,tags
                FROM post
                """;
        return jdbcClient.sql(sql).query(Post.class).list();
    }

    @Override
    public Optional<Post> findById(Integer id) {
        var sql = """
                SELECT id,title,slug,date,time_to_read,tags
                FROM post p
                WHERE id = :id
                """;
        return jdbcClient.sql(sql).param("id", id).query(Post.class).optional();
    }

    @Override
    public void create(Post post) {
        var sql = """
                insert into  post(id,title,slug,date,time_to_read,tags)
                VALUES(?, ?, ?, ?, ?, ?)
                """;
        var updated = jdbcClient
                .sql(sql)
                .params(List.of(post.id(), post.title(), post.slug(), LocalDate.now(), 5, "java")).update();
        Assert.state(updated == 1, "Failed to create post " + post.title());

    }

    @Override
    public void update(Post post, Integer id) {
        var updated = jdbcClient.sql("update post set title = ?, slug = ?,, time_to_read = ?, tags = ? where id = ?")
                .params(List.of(post.title(), post.slug(), post.timeToRead(), post.tags(), id))
                .update();

        Assert.state(updated == 1, "Failed to update post " + post.title());
    }

    @Override
    public void delete(Integer id) {
        var sql = """
                delete
                from post
                where id = :id
                """;
        var updated = jdbcClient.sql(sql).param(id).update();
        Assert.state(updated == 1, "Failed to update post " + id);
    }
}
