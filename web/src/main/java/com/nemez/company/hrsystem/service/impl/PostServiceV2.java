package com.nemez.company.hrsystem.service.impl;

import com.nemez.company.hrsystem.dto.MappingUtils;
import com.nemez.company.hrsystem.dto.PostDto;
import com.nemez.company.hrsystem.model.Post;
import com.nemez.company.hrsystem.repository.PostRepository;
import com.nemez.company.hrsystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import send.MailService;

import java.util.Date;

@Service
public class PostServiceV2 implements PostService {

    private PostRepository postRepository;
    private final MappingUtils mappingUtils;
    private MailService mailService;

    @Autowired
    public PostServiceV2(PostRepository postRepository, MappingUtils mappingUtils) {
        this.postRepository = postRepository;
        this.mappingUtils = mappingUtils;
        mailService = new MailService();
    }

    public void create(PostDto post) {
        post.setDateEdit(new Date());
        Post res = mappingUtils.mapToPost(post);

        postRepository.save(res);
    }

    public void update(PostDto post) {
        Post res = postRepository.getById(post.getId());

        if(res == null) {
            System.out.println("Post not found!");
        }
        else {
            post.setDateEdit(new Date());
            res = mappingUtils.mapToPost(post);
            postRepository.save(res);
            mailService.sendMail("test@gmail.com", "Post with id = " + post.getId() + "was update");
        }
    }

    public PostDto findById(Integer id) {
        PostDto res = mappingUtils.mapToPostDto(postRepository.getById(id));

        return res;
    }

    public void delete(Integer id) {
        postRepository.deleteById(id);
        mailService.sendMail("test@gmail.com", "Post with id = " + id + "was delete");
    }
}
