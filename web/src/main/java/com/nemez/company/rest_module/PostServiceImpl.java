package com.nemez.company.rest_module;

import implementations.PostDaoImpl;
import models.Post;
import org.springframework.stereotype.Service;
import services.PostService;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {

    public PostServiceImpl() {}

    public Post findPost(int id) {
        Post post = new PostService().findPost(id);
        return post;
    }

    public void savePost(Post post) {
        new PostService().savePost(post);
    }

    public void deletePost(Post post) {
        new PostService().deletePost(post);
    }

    public void updatePost(Post post) {
        new PostService().updatePost(post);
    }

   // public List<Post> findAllPosts() { return new PostService().findAllPosts(); }
}
