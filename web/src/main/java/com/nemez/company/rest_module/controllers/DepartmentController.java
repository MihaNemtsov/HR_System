package com.nemez.company.rest_module.controllers;

import com.nemez.company.rest_module.DepartmentServiceImpl;
import models.Departments;
import models.Mens;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class DepartmentController {
    private DepartmentServiceImpl service;

    @Autowired
    public DepartmentController(DepartmentServiceImpl service) {
        this.service = service;
    }

    @PostMapping(value = "/men/create")
    public ResponseEntity<?> create(@RequestBody Departments departments) {
        service.saveDepartment(departments);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/men/read/{id}")
    public ResponseEntity<Mens> read(@PathVariable(name = "id") int id) {
        Departments departments = service.findDepartment(id);

        return departments != null
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/men/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, Departments departments) {
        Departments flag = service.findDepartment(id);

        if(flag != null) {
            flag.setName(departments.getName());
            flag.setParentID(departments.getParentID());
            flag.setMenID(departments.getMenID());
            //flag.setDateEdit(departments.getDateEdit());
            service.updateDepartment(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/men/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable(name = "id") int id) {
        Departments flag = service.findDepartment(id);

        if(flag != null) {
            service.deleteDepartment(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
