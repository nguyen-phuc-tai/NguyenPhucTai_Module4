package com.codegym.model.service;

import com.codegym.model.entity.Catelory;

import java.util.List;

public interface ICateloryService {
    List<Catelory> findAll();
    Catelory findById(Integer id);
    void save(Catelory catelory);
    void update(Catelory catelory);
    void delete(Integer id);
}
