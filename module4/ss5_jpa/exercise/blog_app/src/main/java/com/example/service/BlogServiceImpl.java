package com.example.service;

import com.example.model.Blog;
import com.example.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return this.blogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        this.blogRepository.save(blog);
    }

    @Override
    public List<Blog> findByName(String name) {
        return this.blogRepository.searchByName('%'+name+'%');
    }

    @Override
    public void remove(Blog blog) {
        this.blogRepository.delete(blog);
    }
}
