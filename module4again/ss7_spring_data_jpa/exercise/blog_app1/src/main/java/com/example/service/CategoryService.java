//package com.example.service;
//
//import com.example.model.Category;
//import com.example.repository.ICategoryRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CategoryService implements ICategoryService{
//    @Autowired
//    private ICategoryRepository iCategoryRepository;
//
//    @Override
//    public List<Category> findAll() {
//        return this.iCategoryRepository.findAll();
//    }
//
//    @Override
//    public Category findById(Integer id) {
//        return this.iCategoryRepository.findById(id).orElse(null);
//    }
//}
