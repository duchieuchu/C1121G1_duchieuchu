package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product>findAll();
    void save(Product product);
    void delete(Integer id);
    void update(Integer id, Product product);
    Product findById(Integer id);
    List <Product>findAllByName(String name);
}
