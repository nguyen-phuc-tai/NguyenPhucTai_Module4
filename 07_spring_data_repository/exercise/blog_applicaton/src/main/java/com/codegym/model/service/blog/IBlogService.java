package com.codegym.model.service.blog;

import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    void save(Blog blog);

    Blog findById(Integer id);

    void delete(Integer id);

    Page<Blog> findAllByNameContrains(String name,Pageable pageable);

    Page<Blog> findAllByCategoryId(Integer id, Pageable page);

    List<Blog> findAllByCategory_Id(Integer id);
}