package com.nemez.company.hrsystem.service.impl;

import com.nemez.company.hrsystem.dto.MappingUtils;
import com.nemez.company.hrsystem.dto.MenDto;
import com.nemez.company.hrsystem.model.Mens;
import com.nemez.company.hrsystem.repository.MenRepository;
import com.nemez.company.hrsystem.service.MenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import send.MailService;

import java.util.Date;

@Service
public class MenServiceV2 implements MenService {

    private MenRepository menRepository;
    private final MappingUtils mappingUtils;
    private MailService mailService;

    @Autowired
    public MenServiceV2(MenRepository menRepository, MappingUtils mappingUtils) {
        this.menRepository = menRepository;
        this.mappingUtils = mappingUtils;
        mailService = new MailService();
    }

    @Override
    public void create(MenDto men) {
        Mens res = mappingUtils.mapToMen(men);
        menRepository.save(res);
    }

    @Override
    public void update(MenDto men) {
        Mens res = menRepository.getById(men.getId());

        if(res == null) {
            System.out.println("Men not found!");
        }
        else {
            men.setDateEdit(new Date());
            res = mappingUtils.mapToMen(men);
            menRepository.save(res);
            mailService.sendMail("test@gmail.com", "Post with id = " + men.getId() + "was update");
        }
    }

    @Override
    public MenDto findById(Integer id) {
        MenDto res = mappingUtils.mapToMenDto(menRepository.getById(id));

        return  res;
    }

    @Override
    public void delete(Integer id) {
        menRepository.deleteById(id);
        mailService.sendMail("test@gmail.com", "Post with id = " + id + "was delete");
    }
}
