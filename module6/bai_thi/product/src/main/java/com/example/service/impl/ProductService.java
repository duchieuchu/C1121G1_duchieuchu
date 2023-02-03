package com.example.service.impl;

import com.example.model.product.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;


    @Override
    public Product findProductById(Integer id) {
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {
        iProductRepository.deleteProductById(id);
    }


    @Override
    public List<Product> getAllProduct() {
        return iProductRepository.getAllProduct();
    }


    @Override
    public void save(Product product) {
        iProductRepository.save(product);

    }

    @Override
    public void edit(Product product) {

    }
}
