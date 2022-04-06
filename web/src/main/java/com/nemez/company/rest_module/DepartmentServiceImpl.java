package com.nemez.company.rest_module;

import models.Departments;
import org.springframework.stereotype.Service;
import services.DepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService{
    @Override
    public Departments findDepartment(int id) {
        return new DepartmentService().findDepartment(id);
    }

    @Override
    public void saveDepartment(Departments departments) {
        new DepartmentService().saveDepartment(departments);
    }

    @Override
    public void updateDepartment(Departments departments) {
        new DepartmentService().updateDepartment(departments);
    }

    @Override
    public void deleteDepartment(Departments departments) {
        new DepartmentService().deleteDepartment(departments);
    }
}
