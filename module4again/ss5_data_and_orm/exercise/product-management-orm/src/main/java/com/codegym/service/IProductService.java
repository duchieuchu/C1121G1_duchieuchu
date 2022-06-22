package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    void save(Product product);
    void delete(Product product);
    void update(Integer id,Product product);
    Product findById(Integer id);
}
