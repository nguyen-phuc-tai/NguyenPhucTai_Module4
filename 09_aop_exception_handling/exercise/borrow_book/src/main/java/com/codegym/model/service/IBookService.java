package com.codegym.model.service;

import com.codegym.model.entity.Book;

import java.util.List;

public interface IBookService {

    void save(Book book);

    void deleteById(Integer id);

    Book findById(Integer id);

    List<Book> findAll();
}