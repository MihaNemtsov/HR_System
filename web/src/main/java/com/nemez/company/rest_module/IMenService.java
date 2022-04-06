package com.nemez.company.rest_module;

import models.Mens;

public interface IMenService {

    public Mens findMen(int id);

    public void saveMen(Mens mens);

    public void updateMen(Mens mens);

    public void deleteMen(Mens mens);
}
