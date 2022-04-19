package com.nemez.company.hrsystem.service;

import com.nemez.company.hrsystem.dto.MenDto;

public interface IMenService {

    public MenDto findMen(int id);

    public void saveMen(MenDto mens);

    public void updateMen(MenDto mens);

    public void deleteMen(MenDto mens);
}
