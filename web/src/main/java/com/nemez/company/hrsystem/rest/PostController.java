package com.nemez.company.hrsystem.rest;

import com.nemez.company.hrsystem.dto.PostDto;
import com.nemez.company.hrsystem.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/post")
public class PostController {
    private final PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody PostDto post) {
        service.create(post);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public PostDto read(@PathVariable(name="id") int id) {

        return service.findById(id);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody PostDto post) {
        PostDto res = service.findById(id);

        if(res == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            post.setId(id);
            service.update(post);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity delete (@PathVariable(name = "id") int id) {
        PostDto flag = service.findById(id);

        if(flag == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }

}
