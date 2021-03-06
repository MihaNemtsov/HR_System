package com.nemez.company.hrsystem.rest;

import com.nemez.company.hrsystem.dto.AdminDto;
import com.nemez.company.hrsystem.model.User;
import com.nemez.company.hrsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/admin/")
public class AdminRestController {

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<AdminDto> getUserById(@PathVariable(name = "id") Integer id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        AdminDto result = AdminDto.fromUser(user);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
