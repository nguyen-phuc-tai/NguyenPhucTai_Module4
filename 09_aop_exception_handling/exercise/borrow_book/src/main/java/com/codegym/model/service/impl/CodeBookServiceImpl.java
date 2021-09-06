package com.codegym.model.service.impl;

import com.codegym.model.entity.CodeBook;
import com.codegym.model.repository.ICodeBookRepository;
import com.codegym.model.service.ICodeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeBookServiceImpl implements ICodeBookService {

    @Autowired
    private ICodeBookRepository customerCodeRepository;

    @Override
    public void save(CodeBook customerCode) {
        customerCodeRepository.save(customerCode);
    }

    @Override
    public CodeBook findById(Integer id) {
        return customerCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        customerCodeRepository.deleteById(id);
    }

    @Override
    public CodeBook findByCode(String code) {
        return customerCodeRepository.findByCodeForBook(code);
    }
}
