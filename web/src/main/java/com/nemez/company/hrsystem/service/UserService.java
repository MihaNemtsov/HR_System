package com.nemez.company.hrsystem.service;

import com.nemez.company.hrsystem.model.User;

import java.util.List;

public interface UserService {
    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Integer id);

    void delete(Integer id);
}
