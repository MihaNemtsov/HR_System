package com.nemez.company.hrsystem.service.impl;


import com.nemez.company.hrsystem.dto.MappingUtils;
import com.nemez.company.hrsystem.dto.PostDto;
import com.nemez.company.hrsystem.service.IPostService;
import models.Post;
import org.springframework.stereotype.Service;
import services.PostService;

import java.util.Date;

@Service
public class PostServiceImpl implements IPostService {

    public PostServiceImpl() {}

    public PostDto findPost(int id) {
        MappingUtils mappingUtils = new MappingUtils();
        Post post = new PostService().findPost(id);
        PostDto postDto = new MappingUtils().mapToPostDto(post);

        return postDto;
    }

    public void savePost(PostDto postDto) {
        postDto.setDateEdit(new Date());
        Post post = new MappingUtils().mapToPost(postDto);
        new PostService().savePost(post);
    }

    public void deletePost(PostDto postDto) {
        Post post = new MappingUtils().mapToPost(postDto);
        new PostService().deletePost(post);
    }

    public void updatePost(PostDto postDto) {
        Post post = new MappingUtils().mapToPost(postDto);
        new PostService().updatePost(post);
    }
}
