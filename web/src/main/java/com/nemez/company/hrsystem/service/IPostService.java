package com.nemez.company.hrsystem.service;

import com.nemez.company.hrsystem.dto.PostDto;

public interface IPostService {
    public PostDto findPost(int id);

    public void savePost(PostDto postDto);

    public void deletePost(PostDto postDto);

    public void updatePost(PostDto postDto);

    //public List<Post> findAllPosts();
}
