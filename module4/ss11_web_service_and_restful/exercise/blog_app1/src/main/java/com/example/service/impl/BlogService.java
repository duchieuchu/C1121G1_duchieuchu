package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return this.iBlogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return this.iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public List<Blog> findByName(String name) {
        return this.iBlogRepository.searchByName("%" + name + "%");
    }

    @Override
    public void remove(Blog blog) {
        this.iBlogRepository.delete(blog);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> getBlogByName(String name, Pageable pageable) {
        return this.iBlogRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public Page<Blog> findAllByCategoryName(String name, Pageable pageable) {
        return this.iBlogRepository.findAllByCategory_Name(name,pageable);
    }
}
