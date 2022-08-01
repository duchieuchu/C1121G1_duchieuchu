package com.example.service;


import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }
}
