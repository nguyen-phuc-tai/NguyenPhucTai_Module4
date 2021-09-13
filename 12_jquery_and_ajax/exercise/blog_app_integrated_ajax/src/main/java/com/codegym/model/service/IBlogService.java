package com.codegym.model.service;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAllBlog(Pageable pageable);
    List<Blog> findAllByName(String name);

    Optional<Blog> findById(Integer id);
}
