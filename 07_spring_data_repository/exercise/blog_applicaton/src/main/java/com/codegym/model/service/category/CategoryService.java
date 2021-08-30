package com.codegym.model.service.category;

import com.codegym.model.entity.Category;
import com.codegym.model.repository.category.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Page<Category> findAll(Pageable pageable) {
        return iCategoryRepository.findAll(pageable);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return iCategoryRepository.findById(id).get();
    }

    @Override
    public void delete(Integer id) {
        iCategoryRepository.delete(findById(id));
    }
}