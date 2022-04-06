package com.nemez.company.rest_module;

import models.Mens;
import org.springframework.stereotype.Service;
import services.MenService;

@Service
public class MenServiceImpl implements IMenService {
    @Override
    public Mens findMen(int id) {
        return new MenService().findMen(id);
    }

    @Override
    public void saveMen(Mens mens) {
        new MenService().saveMen(mens);
    }

    @Override
    public void updateMen(Mens mens) {
        new MenService().updateMen(mens);
    }

    @Override
    public void deleteMen(Mens mens) {
        new MenService().deleteMen(mens);
    }
}
