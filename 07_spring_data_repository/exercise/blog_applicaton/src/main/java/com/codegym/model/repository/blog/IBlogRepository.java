package com.codegym.model.repository.blog;

import com.codegym.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAllByNameContains(String name, Pageable page);
    Page<Blog> findAllByCategory_Id(Integer id, Pageable page);
    List<Blog> findAllByCategory_Id(Integer id);
}