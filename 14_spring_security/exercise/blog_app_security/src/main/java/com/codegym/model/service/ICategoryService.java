package com.codegym.model.service;

import com.codegym.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
    Category findById(Integer id);
    void save(Category category);
    void update(Category category);
    void delete(Integer id);
}
