package com.codegym.model.service;

import com.codegym.model.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category findById(int id);
    List<Category> finAll();
}
