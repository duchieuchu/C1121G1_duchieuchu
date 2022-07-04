package com.example.service.impl;

import com.example.model.Blog;
import com.example.repository.IBlogRepository;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;


    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.selectList(pageable);
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.createBlog(blog.getName(), blog.getContent(), blog.getNote(),blog.getCategory().getId());
    }

    @Override
    public void delete(Integer id) {
        this.iBlogRepository.deleteBlogById(id);
    }

    @Override
    public void update(Blog blog) {
        this.iBlogRepository.updateBlog(blog.getName(), blog.getContent(), blog.getNote(),blog.getCategory().getId(),blog.getId());
    }

    @Override
    public Blog findById(Integer id) {
        return this.iBlogRepository.selectBlogById(id);
    }

    @Override
    public Page<Blog> findAllByName(String name, Pageable pageable) {
        return this.iBlogRepository.selectListByName("%" + name + "%", pageable);
    }

    @Override
    public Page<Blog> findAllByCategoryName(String name, Pageable pageable) {
        return this.iBlogRepository.findAllByCategory_Name(name,pageable);
    }
}
