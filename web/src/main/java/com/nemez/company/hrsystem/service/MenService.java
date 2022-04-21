package com.nemez.company.hrsystem.service;

import com.nemez.company.hrsystem.model.Mens;

import java.util.List;

public interface MenService {
    void create(Mens men);

    void update(Mens men);

    List<Mens> getAll();

    Mens findById(Integer id);

    void delete(Integer id);
}
