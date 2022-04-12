package com.nemez.company.rest_module;

import com.nemez.company.rest_module.dto.DepartmentDto;

public interface IDepartmentService {
    public DepartmentDto findDepartment(int id);

    public void saveDepartment(DepartmentDto departments);

    public void updateDepartment(DepartmentDto departments);

    public void deleteDepartment(DepartmentDto departments);
}
