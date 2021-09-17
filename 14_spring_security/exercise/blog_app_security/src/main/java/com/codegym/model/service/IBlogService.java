package com.codegym.model.service;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);
     Optional<Blog> findById(Integer id);
    void save(Blog blog);
    void update(Blog blog);
    void delete(Integer id);
    Page<Blog> findAllByOrderByDateBlogAsc(Pageable pageable);
    Page<Blog> findAllByNameBlogContaining(String searchName,Pageable pageable);
}
