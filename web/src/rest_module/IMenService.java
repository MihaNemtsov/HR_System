package com.nemez.company.rest_module;

import com.nemez.company.rest_module.dto.MenDto;

public interface IMenService {

    public MenDto findMen(int id);

    public void saveMen(MenDto mens);

    public void updateMen(MenDto mens);

    public void deleteMen(MenDto mens);
}
