package com.example.service;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void delete(Integer id) {

    }

    @Override
    public void update(Blog blog) {

    }

    @Override
    public Blog findById(Integer id) {
        return null;
    }
}
