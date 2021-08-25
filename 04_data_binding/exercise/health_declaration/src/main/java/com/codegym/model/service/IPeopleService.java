package com.codegym.model.service;

import com.codegym.model.bean.People;

import java.util.List;

public interface IPeopleService {
    List<People> findAll();

    People findOne(Long id);

    void save(People people);
}
