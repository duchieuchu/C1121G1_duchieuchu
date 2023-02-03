package com.example.service;

import com.example.model.product.Product;

import java.util.List;

public interface IProductService {
    Product findProductById(Integer id);
    void deleteProduct(Integer id);
    List<Product> getAllProduct();
    void save(Product product);
    void edit(Product product);
}
