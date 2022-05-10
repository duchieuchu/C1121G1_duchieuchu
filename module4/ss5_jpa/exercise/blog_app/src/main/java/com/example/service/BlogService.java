package com.example.service;

import com.example.model.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void update( Blog blog);

    List<Blog> findByName(String name);
    void remove(Blog blog);
}
