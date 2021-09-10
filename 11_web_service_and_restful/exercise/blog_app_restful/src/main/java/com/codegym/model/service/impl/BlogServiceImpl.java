package com.codegym.model.service.impl;

import com.codegym.model.entity.Blog;
import com.codegym.model.repository.IBlogRepository;
import com.codegym.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }
}