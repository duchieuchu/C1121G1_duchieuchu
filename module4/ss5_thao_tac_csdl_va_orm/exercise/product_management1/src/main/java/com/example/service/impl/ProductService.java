package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository IProductRepository;

    @Override
    public List<Product> findAll() {
        return this.IProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.IProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return this.IProductRepository.findById(id);
    }

    @Override
    public void update(Integer id, Product product) {
        this.IProductRepository.update(id, product);
    }

    @Override
    public void remove(Product product) {
        this.IProductRepository.remove(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.IProductRepository.findByName(name);
    }
}
