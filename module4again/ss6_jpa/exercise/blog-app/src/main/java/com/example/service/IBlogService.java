package com.example.service;

import com.example.model.Blog;

import javax.swing.*;
import java.util.List;

public interface IBlogService {
    List<Blog>findAll();
    void save(Blog blog);
    void delete(Integer id);
    void update(Blog blog);
    Blog findById(Integer id);
    List<Blog>findAllByName(String name);
}
