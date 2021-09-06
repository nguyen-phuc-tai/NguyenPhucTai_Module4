package com.codegym.model.repository;

import com.codegym.model.entity.CodeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeBookRepository extends JpaRepository<CodeBook, Integer> {
    CodeBook findByCodeForBook(String code);
}
