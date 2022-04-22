package com.nemez.company.hrsystem.service;

import com.nemez.company.hrsystem.dto.PostDto;

public interface PostService {
    void create(PostDto post);

    void update(PostDto post);

    PostDto findById(Integer id);

    void delete(Integer id);
}
