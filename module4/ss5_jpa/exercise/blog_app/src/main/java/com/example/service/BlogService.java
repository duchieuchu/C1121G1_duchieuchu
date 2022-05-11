package com.example.service;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository IBlogRepository;

    @Override
    public List<Blog> findAll() {
        return this.IBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        this.IBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return this.IBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        this.IBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findByName(String name) {
        return this.IBlogRepository.searchByName('%'+name+'%');
    }

    @Override
    public void remove(Blog blog) {
        this.IBlogRepository.delete(blog);
    }
}
