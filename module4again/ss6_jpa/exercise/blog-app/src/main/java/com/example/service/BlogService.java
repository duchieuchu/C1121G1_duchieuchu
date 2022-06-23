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
        return this.iBlogRepository.selectList();
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }


    @Override
    public void delete(Blog blog) {
        this.iBlogRepository.delete(blog);
    }

    @Override
    public void update(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return this.iBlogRepository.selectBlogById(id);
    }
}
