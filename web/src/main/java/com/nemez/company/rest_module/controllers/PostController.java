package com.nemez.company.rest_module.controllers;

import com.nemez.company.rest_module.PostServiceImpl;
import models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class PostController {
    private final PostServiceImpl service;

    @Autowired
    public PostController (PostServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/post/create")
    public ResponseEntity<?> create(@RequestBody Post post) {
        service.savePost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/post/read/{id}")
    public ResponseEntity<Post> read(@PathVariable(name="id") int id) {
        Post post = service.findPost(id);

        return post != null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/post/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Post post) {
        Post flag = service.findPost(id);
        if(flag == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            flag.setTitle(post.getTitle());
            flag.setDateEdit(new Date());
            service.updatePost(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/post/delete/{id}")
    public ResponseEntity delete (@PathVariable(name = "id") int id) {
        Post flag = service.findPost(id);

        //System.out.println(flag.getTitle());

        if(flag == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            service.deletePost(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
