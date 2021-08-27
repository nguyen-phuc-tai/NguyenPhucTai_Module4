package com.codegym.model.service;

import com.codegym.model.bean.People;
import com.codegym.model.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceimpl implements IPeopleService{

    @Autowired
    private PeopleRepository peopleRepository;

    @Override
    public List<People> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    public People findOne(Long id) {
        return peopleRepository.findOne(id);
    }

    @Override
    public void save(People people) {
        peopleRepository.save(people);
    }
}
