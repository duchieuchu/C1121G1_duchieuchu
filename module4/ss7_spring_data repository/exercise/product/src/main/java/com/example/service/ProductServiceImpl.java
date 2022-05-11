package com.example.service;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements IProductService{
    @Autowired
    private IProductRepository iProductRepository;
    @Override
    public List<Product> findAll() {
        return this.iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return this.iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return this.iProductRepository.searchByName(name);
    }

    @Override
    public void remove(Product product) {
        this.iProductRepository.delete(product);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.iProductRepository.findAll(pageable);
    }

    @Override
    public Page<Product> getProductByName(String name, Pageable pageable) {
        return this.iProductRepository.findAllByNameContaining(name,pageable);
    }
}
