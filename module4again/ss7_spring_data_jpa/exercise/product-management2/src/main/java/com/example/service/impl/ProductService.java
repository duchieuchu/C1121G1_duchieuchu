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
    public Page<Product> findAll(Pageable pageable) {
        return this.iProductRepository.selectList(pageable);
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.createProduct(product.getName1(), product.getInfo1(), product.getQuantity1(), product.getMade1(), product.getCategory().getId1());
    }

    @Override
    public void delete(Integer id) {
        this.iProductRepository.deleteBlogById(id);
    }

    @Override
    public void update(Product product) {
this.iProductRepository.updateBlog(product.getName1(), product.getInfo1(), product.getQuantity1(), product.getMade1(), product.getCategory().getId1(),product.getId1());
    }

    @Override
    public Product findById(Integer id) {
        return this.iProductRepository.selectProductById(id);
    }
}
