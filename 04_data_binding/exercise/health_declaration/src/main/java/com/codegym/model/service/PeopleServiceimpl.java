package com.codegym.model.service;

import com.codegym.model.bean.People;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeopleServiceimpl implements IPeopleService{

    private List<People> listpeople = new ArrayList<>();

    @Override
    public void save(People people) {
        listpeople.add(people);
    }
}
