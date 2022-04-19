package com.nemez.company.hrsystem.service.impl;

import com.nemez.company.hrsystem.dto.DepartmentDto;
import com.nemez.company.hrsystem.dto.MappingUtils;
import com.nemez.company.hrsystem.service.IDepartmentService;
import models.Departments;
import org.springframework.stereotype.Service;
import services.DepartmentService;

import java.util.Date;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Override
    public DepartmentDto findDepartment(int id) {
        return new MappingUtils().mapToDepartmentDto(new DepartmentService().findDepartment(id));
    }

    @Override
    public void saveDepartment(DepartmentDto departments) {
        departments.setDateEdit(new Date());
        Departments dep = new MappingUtils().mapToDepartment(departments);
        new DepartmentService().saveDepartment(dep);
    }

    @Override
    public void updateDepartment(DepartmentDto departments) {
        Departments dep = new MappingUtils().mapToDepartment(departments);
        new DepartmentService().updateDepartment(dep);
    }

    @Override
    public void deleteDepartment(DepartmentDto departments) {
        Departments dep = new MappingUtils().mapToDepartment(departments);
        new DepartmentService().deleteDepartment(dep);
    }
}
