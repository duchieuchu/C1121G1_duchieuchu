package com.example.service;

import com.example.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> finaAll();
    Category findById(Integer id);
}
