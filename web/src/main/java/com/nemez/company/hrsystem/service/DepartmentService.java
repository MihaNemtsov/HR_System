package com.nemez.company.hrsystem.service;

import com.nemez.company.hrsystem.model.Departments;

import java.util.List;

public interface DepartmentService {
    void create(Departments departments);

    void update(Departments departments);

    List<Departments> getAll();

    Departments findById(Integer id);

    void delete(Integer id);
}
