package com.codegym.model.service;

import com.codegym.model.entity.CodeBook;

public interface ICodeBookService {

    void save(CodeBook customerCode);

    CodeBook findById(Integer id);

    void delete(Integer id);

    CodeBook findByCode(String code);
}
