package com.codegym.model.service;

import com.codegym.model.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(int id);
}
