package com.nemez.company.hrsystem.service.impl;

import com.nemez.company.hrsystem.dto.DepartmentDto;
import com.nemez.company.hrsystem.dto.MappingUtils;
import com.nemez.company.hrsystem.model.Departments;
import com.nemez.company.hrsystem.model.Post;
import com.nemez.company.hrsystem.repository.DepartmentRepository;
import com.nemez.company.hrsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import send.MailService;

import java.util.Date;

@Service
public class DepartmentServiceV2 implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private final MappingUtils mappingUtils;
    private MailService mailService;

    @Autowired
    public DepartmentServiceV2(DepartmentRepository departmentRepository, MappingUtils mappingUtils) {
        this.departmentRepository = departmentRepository;
        this.mappingUtils = mappingUtils;
        mailService = new MailService();
    }

    @Override
    public void create(DepartmentDto departments) {
        departments.setDateEdit(new Date());
        Departments res = mappingUtils.mapToDepartment(departments);

        departmentRepository.save(res);
    }

    @Override
    public void update(DepartmentDto departments) {
        Departments res = departmentRepository.getById(departments.getId());

        if(res == null) {
            System.out.println("Post not found!");
        }
        else {
            departments.setDateEdit(new Date());
            res = mappingUtils.mapToDepartment(departments);
            departmentRepository.save(res);
            mailService.sendMail("test@gmail.com", "Department with id = " + departments.getId() + "was update");
        }
    }

    @Override
    public DepartmentDto findById(Integer id) {
        DepartmentDto res = mappingUtils.mapToDepartmentDto(departmentRepository.getById(id));

        return res;
    }

    @Override
    public void delete(Integer id) {
        mailService.sendMail("test@gmail.com", "Department with id = " + id + "was delete");
        departmentRepository.deleteById(id);
    }
}
