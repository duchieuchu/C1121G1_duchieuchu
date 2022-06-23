package com.example.service;

import com.example.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog>findAll(Pageable pageable);
    void save(Blog blog);
    void delete(Integer id);
    void update(Blog blog);
    Blog findById(Integer id);
}
