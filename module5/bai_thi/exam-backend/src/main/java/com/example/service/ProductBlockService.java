package com.example.service;

import com.example.model.ProductBlock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductBlockService implements IProductBlockService{
    @Override
    public Page<ProductBlock> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void save(ProductBlock productBlock) {

    }

    @Override
    public ProductBlock findById(Integer id) {
        return null;
    }

    @Override
    public void delete(ProductBlock productBlock) {

    }

    @Override
    public Page<ProductBlock> findAllByDate(String name, Pageable pageable) {
        return null;
    }
}
