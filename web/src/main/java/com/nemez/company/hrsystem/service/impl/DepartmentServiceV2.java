package com.nemez.company.hrsystem.service.impl;

import com.nemez.company.hrsystem.model.Departments;
import com.nemez.company.hrsystem.repository.DepartmentRepository;
import com.nemez.company.hrsystem.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import send.MailService;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceV2 implements DepartmentService {
    private DepartmentRepository departmentRepository;
    private MailService mailService;

    @Autowired
    public DepartmentServiceV2(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        mailService = new MailService();
    }

    @Override
    public void create(Departments departments) {
        departmentRepository.save(departments);
    }

    @Override
    public void update(Departments departments) {
        Departments res = departmentRepository.findById(departments.getId()).orElse(null);

            res.setName(departments.getName());
            res.setMenID(departments.getMenID());
            res.setParentID(departments.getParentID());
            res.setDateEdit(new Date());
            mailService.sendMail("hatulmadan@gmail.com", "Department with id = " + res.getId() + "was update");

    }

    @Override
    public List<Departments> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Departments findById(Integer id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        mailService.sendMail("hatulmadan@gmail.com", "Department with id = " + id + "was delete");
        departmentRepository.deleteById(id);
    }
}
