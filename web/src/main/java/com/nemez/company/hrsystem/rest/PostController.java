package com.nemez.company.hrsystem.rest;

import com.nemez.company.hrsystem.dto.MappingUtils;
import com.nemez.company.hrsystem.dto.PostDto;
import com.nemez.company.hrsystem.model.Post;
import com.nemez.company.hrsystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/post")
public class PostController {
    private final PostService service;
    private final MappingUtils mappingUtils;

    @Autowired
    public PostController(PostService service, MappingUtils mappingUtils) {
        this.service = service;
        this.mappingUtils = mappingUtils;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody PostDto post) {
        Post res = mappingUtils.mapToPost(post);
        service.create(res);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public PostDto read(@PathVariable(name="id") int id) {
        Post post = service.findById(id);
        PostDto res = mappingUtils.mapToPostDto(post);

        return res;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody PostDto post) {
        Post res = service.findById(id);

        if(res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            post.setId(id);
            res = mappingUtils.mapToPost(post);
            service.update(res);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete (@PathVariable(name = "id") int id) {
        Post flag = service.findById(id);

        if(flag == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
