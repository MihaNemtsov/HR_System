package com.nemez.company.hrsystem.service;

import com.nemez.company.hrsystem.model.Post;

import java.util.List;

public interface PostService {
    void create(Post post);

    void update(Post post);

    List<Post> getAll();

    Post findById(Integer id);

    void delete(Integer id);
}
