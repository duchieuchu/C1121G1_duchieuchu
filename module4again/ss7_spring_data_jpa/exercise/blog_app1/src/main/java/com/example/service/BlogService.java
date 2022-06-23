package com.example.service;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.findAll(pageable);
    }

    @Override
    public void save(Blog blog) {

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
