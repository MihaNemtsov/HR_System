package com.nemez.company.hrsystem.service;

import com.nemez.company.hrsystem.dto.MenDto;

public interface MenService {
    void create(MenDto men);

    void update(MenDto men);

    MenDto findById(Integer id);

    void delete(Integer id);
}
