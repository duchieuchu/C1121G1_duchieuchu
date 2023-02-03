package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product>getPageProduct(Pageable pageable);

    Product getProductById(Integer id);

    void createProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Integer id);
}
