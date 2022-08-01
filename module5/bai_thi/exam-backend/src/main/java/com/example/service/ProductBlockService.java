package com.example.service;

import com.example.model.ProductBlock;
import com.example.repository.IProductBlockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductBlockService implements IProductBlockService {
    @Autowired
    private IProductBlockRepository iProductBlockRepository;

    @Override
    public Page<ProductBlock> findAll(Pageable pageable) {
        return iProductBlockRepository.findAll(pageable);
    }

    @Override
    public List<ProductBlock> findAll() {
        return iProductBlockRepository.findAll();
    }

    @Override
    public void save(ProductBlock productBlock) {
        iProductBlockRepository.save(productBlock);
    }

    @Override
    public ProductBlock findById(Integer id) {
        return iProductBlockRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        iProductBlockRepository.deleteById(id);
    }

    @Override
    public Page<ProductBlock> findAllByDate(String name, Pageable pageable) {
        return null;
    }
}
