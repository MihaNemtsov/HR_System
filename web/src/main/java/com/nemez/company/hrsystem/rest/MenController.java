package com.nemez.company.hrsystem.rest;

import com.nemez.company.hrsystem.dto.MappingUtils;
import com.nemez.company.hrsystem.dto.MenDto;
import com.nemez.company.hrsystem.model.Mens;
import com.nemez.company.hrsystem.service.MenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/men")
public class MenController {
    private MenService service;
    private MappingUtils mappingUtils;

    @Autowired
    public MenController(MenService service, MappingUtils mappingUtils) {
        this.service = service;
        this.mappingUtils = mappingUtils;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody MenDto mens) {
        Mens res = mappingUtils.mapToMen(mens);
        service.create(res);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{id}")
    public MenDto read(@PathVariable(name = "id") int id) {
        Mens men = service.findById(id);
        MenDto res = mappingUtils.mapToMenDto(men);

        return res;
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody MenDto mens) {
        Mens flag = service.findById(id);

        if(flag != null) {
            mens.setId(id);
            flag = mappingUtils.mapToMen(mens);
            service.update(flag);

            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?>delete(@PathVariable(name = "id") int id) {
        Mens flag = service.findById(id);

        if(flag != null) {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
