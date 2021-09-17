package com.codegym.model.service.impl;

import com.codegym.model.entity.Category;
import com.codegym.model.repository.ICateloryRepository;
import com.codegym.model.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    ICateloryRepository cateloryRepository;


    @Override
    public List<Category> findAll() {
        return cateloryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return cateloryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Category category) {
        cateloryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        cateloryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        cateloryRepository.deleteById(id);
    }
}
