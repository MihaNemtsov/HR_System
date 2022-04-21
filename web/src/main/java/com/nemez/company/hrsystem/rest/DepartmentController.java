package com.nemez.company.hrsystem.rest;

import com.nemez.company.hrsystem.dto.DepartmentDto;
import com.nemez.company.hrsystem.dto.MappingUtils;
import com.nemez.company.hrsystem.model.Departments;
import com.nemez.company.hrsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService service;
    private final MappingUtils mappingUtils;

    @Autowired
    public DepartmentController(DepartmentService service, MappingUtils mappingUtils) {
        this.service = service;
        this.mappingUtils = mappingUtils;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody DepartmentDto departments) {
        Departments res = mappingUtils.mapToDepartment(departments);
        service.create(res);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public DepartmentDto read(@PathVariable(name = "id") int id) {
        Departments res = service.findById(id);
        DepartmentDto departments = mappingUtils.mapToDepartmentDto(res);

        return departments;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, DepartmentDto departments) {
        Departments flag = service.findById(id);

        if(flag != null) {
            departments.setId(id);
            flag = mappingUtils.mapToDepartment(departments);
            service.update(flag);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable(name = "id") int id) {
        Departments flag = service.findById(id);

        if(flag != null) {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
