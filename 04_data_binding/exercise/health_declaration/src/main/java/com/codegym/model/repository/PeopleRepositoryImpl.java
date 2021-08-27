package com.codegym.model.repository;

import com.codegym.model.bean.People;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PeopleRepositoryImpl implements PeopleRepository{

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
