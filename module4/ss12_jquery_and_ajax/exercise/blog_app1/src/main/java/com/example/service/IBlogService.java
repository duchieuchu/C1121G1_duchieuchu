package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    List<Blog> findByName(String name);

    void remove(Blog blog);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> getBlogByName(String name, Pageable pageable);

    Page<Blog> findAllByCategoryName(String name, Pageable pageable);

    Page<Blog> findAllByName(Pageable pageable, String name);
}
