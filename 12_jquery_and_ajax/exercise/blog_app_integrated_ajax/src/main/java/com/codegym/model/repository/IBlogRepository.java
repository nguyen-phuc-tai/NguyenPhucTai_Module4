package com.codegym.model.repository;

import com.codegym.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where name like %?1%",nativeQuery = true)
    public List<Blog> findAllByName(String keyword);
}
