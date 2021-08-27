package com.codegym.model.repository;

import com.codegym.model.bean.People;

import java.util.List;

public interface PeopleRepository {
    List<People> findAll();

    People findOne(Long id);

    void save(People people);
}
