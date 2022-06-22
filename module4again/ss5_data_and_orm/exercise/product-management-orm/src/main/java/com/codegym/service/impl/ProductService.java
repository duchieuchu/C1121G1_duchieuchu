package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
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
    public void delete(Product product) {
        this.iProductRepository.delete(product);
    }


    @Override
    public void update(Integer id, Product product) {
        this.iProductRepository.update(id,product);
    }

    @Override
    public Product findById(Integer id) {
        return this.iProductRepository.findById(id);
    }
}
