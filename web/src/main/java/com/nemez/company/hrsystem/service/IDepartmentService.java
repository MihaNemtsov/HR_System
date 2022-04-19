package com.nemez.company.hrsystem.service;

import com.nemez.company.hrsystem.dto.DepartmentDto;

public interface IDepartmentService {
    public DepartmentDto findDepartment(int id);

    public void saveDepartment(DepartmentDto departments);

    public void updateDepartment(DepartmentDto departments);

    public void deleteDepartment(DepartmentDto departments);
}
