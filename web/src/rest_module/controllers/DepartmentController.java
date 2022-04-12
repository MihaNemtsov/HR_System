package com.nemez.company.rest_module.controllers;

import com.nemez.company.rest_module.dto.DepartmentDto;
import com.nemez.company.rest_module.service.DepartmentServiceImpl;
import models.Mens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(path = "department")
public class DepartmentController {
    private DepartmentServiceImpl service;

    @Autowired
    public DepartmentController(DepartmentServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "create")
    public ResponseEntity<?> create(@RequestBody DepartmentDto departments) {
        service.saveDepartment(departments);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "read/{id}")
    public ResponseEntity<Mens> read(@PathVariable(name = "id") int id) {
        DepartmentDto departments = service.findDepartment(id);

        return departments != null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, DepartmentDto departments) {
        DepartmentDto flag = service.findDepartment(id);

        if(flag != null) {
            flag.setName(departments.getName());
            flag.setParentID(departments.getParentID());
            flag.setMenID(departments.getMenID());
            flag.setDateEdit(new Date());
            service.updateDepartment(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<?>delete(@PathVariable(name = "id") int id) {
        DepartmentDto flag = service.findDepartment(id);

        if(flag != null) {
            service.deleteDepartment(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
