package com.codegym.model.service.category;

import com.codegym.model.bean.Blog;
import com.codegym.model.bean.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();

    Page<Category> findAll(Pageable pageable);

    void save(Category category);

    Category findById(Integer id);

    void delete(Integer id);
}
