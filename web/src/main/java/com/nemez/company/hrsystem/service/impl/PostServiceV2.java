package com.nemez.company.hrsystem.service.impl;

import com.nemez.company.hrsystem.model.Post;
import com.nemez.company.hrsystem.repository.PostRepository;
import com.nemez.company.hrsystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import send.MailService;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceV2 implements PostService {

    private PostRepository postRepository;
    private MailService mailService;

    @Autowired
    public PostServiceV2(PostRepository postRepository) {
        this.postRepository = postRepository;
        mailService = new MailService();
    }

    public void create(Post post) {
        post.setDateEdit(new Date());
        postRepository.save(post);
    }

    public void update(Post post) {
        Post res = postRepository.getById(post.getId());

        if(res == null) {
            System.out.println("Post not found!");
        }
        else {
            res.setTitle(post.getTitle());
            res.setDateEdit(new Date());
            postRepository.save(res);
            mailService.sendMail("hatulmadan@gmail.com", "Post with id = " + post.getId() + "was update");
        }
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post findById(Integer id) {
        return postRepository.getById(id);
    }

    public void delete(Integer id) {
        postRepository.deleteById(id);
        mailService.sendMail("hatulmadan@gmail.com", "Post with id = " + id + "was delete");
    }
}
