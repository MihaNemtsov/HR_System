package com.nemez.company.hrsystem.service.impl;

import com.nemez.company.hrsystem.dto.MappingUtils;
import com.nemez.company.hrsystem.dto.MenDto;
import com.nemez.company.hrsystem.service.IMenService;
import models.Mens;
import org.springframework.stereotype.Service;
import services.MenService;

import java.util.Date;

@Service
public class MenServiceImpl implements IMenService {
    @Override
    public MenDto findMen(int id) {
        Mens mens = new MenService().findMen(id);

        return new MappingUtils().mapToMenDto(mens);
    }

    @Override
    public void saveMen(MenDto menDto) {
        menDto.setDateEdit(new Date());
        new MenService().saveMen(new MappingUtils().mapToMen(menDto));
    }

    @Override
    public void updateMen(MenDto menDto) {
        new MenService().updateMen(new MappingUtils().mapToMen(menDto));
    }

    @Override
    public void deleteMen(MenDto menDto) {
        new MenService().deleteMen(new MappingUtils().mapToMen(menDto));
    }
}
