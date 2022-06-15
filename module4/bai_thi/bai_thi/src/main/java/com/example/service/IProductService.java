package com.example.service;

import com.example.model.Product;
import com.example.model.TypeProduct;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);
}
