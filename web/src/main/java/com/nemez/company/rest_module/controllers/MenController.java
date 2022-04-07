package com.nemez.company.rest_module.controllers;

import com.nemez.company.rest_module.MenServiceImpl;
import models.Mens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class MenController {
    private MenServiceImpl service;

    @Autowired
    public MenController(MenServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/men/create")
    public ResponseEntity<?> create(@RequestBody Mens mens) {
        service.saveMen(mens);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/men/read/{id}")
    public ResponseEntity<Mens> read(@PathVariable(name = "id") int id) {
        Mens mens = service.findMen(id);

        return mens != null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/men/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody Mens mens) {
        Mens flag = service.findMen(id);

        if(flag != null) {
            flag.setFio(mens.getFio());
            flag.setDepartmentID(mens.getDepartmentID());
            flag.setPostID(mens.getPostID());
            flag.setDateEdit(new Date());
            flag.setRole(mens.getRole());
            service.updateMen(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/men/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable(name = "id") int id) {
        Mens flag = service.findMen(id);

        if(flag != null) {
            service.deleteMen(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
