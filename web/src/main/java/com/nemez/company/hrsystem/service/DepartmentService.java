package com.nemez.company.hrsystem.service;

import com.nemez.company.hrsystem.dto.DepartmentDto;

public interface DepartmentService {
    void create(DepartmentDto departments);

    void update(DepartmentDto departments);

    DepartmentDto findById(Integer id);

    void delete(Integer id);
}
