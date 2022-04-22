package com.nemez.company.hrsystem.rest;

import com.nemez.company.hrsystem.dto.MenDto;
import com.nemez.company.hrsystem.service.MenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/men")
public class MenController {
    private MenService service;

    @Autowired
    public MenController(MenService service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody MenDto mens) {
        service.create(mens);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public MenDto read(@PathVariable(name = "id") int id) {
        return service.findById(id);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody MenDto mens) {
        MenDto flag = service.findById(id);

        if(flag != null) {
            mens.setId(id);
            service.update(mens);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable(name = "id") int id) {
        MenDto flag = service.findById(id);

        if(flag != null) {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
