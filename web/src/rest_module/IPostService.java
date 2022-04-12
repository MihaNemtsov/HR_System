package com.nemez.company.rest_module;

import com.nemez.company.rest_module.dto.PostDto;
import models.Post;

import java.util.List;

public interface IPostService {
    public PostDto findPost(int id);

    public void savePost(PostDto postDto);

    public void deletePost(PostDto postDto);

    public void updatePost(PostDto postDto);

    //public List<Post> findAllPosts();
}
