package com.nemez.company.hrsystem.service.impl;

import com.nemez.company.hrsystem.model.Mens;
import com.nemez.company.hrsystem.repository.MenRepository;
import com.nemez.company.hrsystem.service.MenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import send.MailService;

import java.util.Date;
import java.util.List;

@Service
public class MenServiceV2 implements MenService {

    private MenRepository menRepository;
    private MailService mailService;

    @Autowired
    public MenServiceV2(MenRepository menRepository) {
        this.menRepository = menRepository;
        mailService = new MailService();
    }

    @Override
    public void create(Mens men) {
        menRepository.save(men);
    }

    @Override
    public void update(Mens men) {
        Mens mens = menRepository.getById(men.getId());

        mens.setFio(men.getFio());
        mens.setDepartmentID(men.getDepartmentID());
        mens.setPostID(men.getPostID());
        mens.setRole(men.getRole());
        mens.setDateEdit(new Date());
    }

    @Override
    public List<Mens> getAll() {
        return menRepository.findAll();
    }

    @Override
    public Mens findById(Integer id) {
        return menRepository.getById(id);
    }

    @Override
    public void delete(Integer id) {

    }
}
