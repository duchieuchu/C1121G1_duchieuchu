package com.example.book.service.impl;

import com.example.book.models.Category;
import com.example.book.repository.ICategoryRepository;
import com.example.book.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> getAllCategory() {
        return this.iCategoryRepository.findAll();
    }
}
