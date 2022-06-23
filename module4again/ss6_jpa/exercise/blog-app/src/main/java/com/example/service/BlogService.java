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
        this.iBlogRepository.createBlog(blog.getName(), blog.getContent(), blog.getNote());
    }


    @Override
    public void delete(Integer id) {
        this.iBlogRepository.deleteBlogById(id);
    }

    @Override
    public void update(Blog blog) {
        this.iBlogRepository.updateBlog(blog.getName(), blog.getContent(), blog.getNote(),blog.getId());
    }

    @Override
    public Blog findById(Integer id) {
        return this.iBlogRepository.selectBlogById(id);
    }
}
