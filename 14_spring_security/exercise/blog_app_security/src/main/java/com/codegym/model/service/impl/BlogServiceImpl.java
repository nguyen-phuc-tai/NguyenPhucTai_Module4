package com.codegym.model.service.impl;

import com.codegym.model.entity.Blog;
import com.codegym.model.repository.IBlogReporitory;
import com.codegym.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogReporitory blogReporitory;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogReporitory.findAll(pageable);
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogReporitory.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogReporitory.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogReporitory.save(blog);
    }

    @Override
    public void delete(Integer id) {
        blogReporitory.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByOrderByDateBlogAsc(Pageable pageable) {
        return blogReporitory.findAllByOrderByDateBlogAsc(pageable);
    }

    @Override
    public Page<Blog> findAllByNameBlogContaining(String searchName, Pageable pageable) {
        return blogReporitory.findAllByNameBlogContaining(searchName,pageable);
    }
}
