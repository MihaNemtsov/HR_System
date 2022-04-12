package com.nemez.company.rest_module.service;

import com.nemez.company.rest_module.IMenService;
import com.nemez.company.rest_module.dto.MappingUtils;
import com.nemez.company.rest_module.dto.MenDto;
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
