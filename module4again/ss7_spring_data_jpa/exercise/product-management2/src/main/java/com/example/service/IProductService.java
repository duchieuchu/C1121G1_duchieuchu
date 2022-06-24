package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product>findAll(Pageable pageable);
    void save(Product product);
    void delete(Integer id);
    void update(Product product);
    Product findById(Integer id);
}
