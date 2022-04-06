package com.nemez.company.rest_module;

import models.Departments;

public interface IDepartmentService {
    public Departments findDepartment(int id);

    public void saveDepartment(Departments departments);

    public void updateDepartment(Departments departments);

    public void deleteDepartment(Departments departments);
}
