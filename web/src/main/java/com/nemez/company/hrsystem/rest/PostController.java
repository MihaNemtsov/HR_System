package com.nemez.company.hrsystem.rest;

import com.nemez.company.hrsystem.dto.PostDto;
import com.nemez.company.hrsystem.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping(path = "/post")
public class PostController {
    private final PostServiceImpl service;

    @Autowired
    public PostController (PostServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody PostDto post) {
        service.savePost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public PostDto read(@PathVariable(name="id") int id) {
        return service.findPost(id);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody PostDto post) {
        PostDto flag = service.findPost(id);

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

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete (@PathVariable(name = "id") int id) {
        PostDto flag = service.findPost(id);

        if(flag == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            service.deletePost(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
