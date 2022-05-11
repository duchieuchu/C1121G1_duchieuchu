package com.example.service;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    Product findById(Integer id);

    void update( Product product);

    List<Product> findByName(String name);
    void remove(Product product);
    Page<Product> findAll(Pageable pageable);
    Page<Product>getProductByName(String name, Pageable pageable);
}
