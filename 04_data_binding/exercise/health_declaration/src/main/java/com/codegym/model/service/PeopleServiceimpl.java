package com.codegym.model.service;

import com.codegym.model.bean.People;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@Service
public class PeopleServiceimpl implements IPeopleService{

    private static List<People> listpeople = new ArrayList<>();

    @Override
    public List<People> findAll() {
        return new ArrayList<>(listpeople);
    }

    @Override
    public People findOne(Long id) {
        return listpeople.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void save(People people) {
        listpeople.add(people);
    }
}
