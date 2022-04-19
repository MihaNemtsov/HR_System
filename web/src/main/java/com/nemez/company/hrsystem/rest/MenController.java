package com.nemez.company.hrsystem.rest;

import com.nemez.company.hrsystem.dto.MenDto;
import com.nemez.company.hrsystem.service.impl.MenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Date;

@RestController
@RequestMapping(path = "/men")
public class MenController {
    private MenServiceImpl service;

    @Autowired
    public MenController(MenServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody MenDto mens) {
        service.saveMen(mens);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public MenDto read(@PathVariable(name = "id") int id) {
        MenDto mens = service.findMen(id);

        return mens;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody MenDto mens) {
        MenDto flag = service.findMen(id);

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

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable(name = "id") int id) {
        MenDto flag = service.findMen(id);

        if(flag != null) {
            service.deleteMen(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
