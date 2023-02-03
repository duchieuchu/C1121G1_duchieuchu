package com.example.service.impl;

import com.example.model.Product;
import com.example.repository.IProductRepository;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> getPageProduct(Pageable pageable) {
        return iProductRepository.selectAllProductPage(pageable);
    }

    @Override
    public Product getProductById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void createProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void editProduct(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        iProductRepository.deleteProduct(id);
    }
}
