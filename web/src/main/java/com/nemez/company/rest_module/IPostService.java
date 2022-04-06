package com.nemez.company.rest_module;

import models.Post;

import java.util.List;

public interface IPostService {
    public Post findPost(int id);

    public void savePost(Post post);

    public void deletePost(Post post);

    public void updatePost(Post post);

    //public List<Post> findAllPosts();
}
