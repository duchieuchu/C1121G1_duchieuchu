package com.example.service;

import com.example.model.ProductBlock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductBlockService {
    Page<ProductBlock> findAll(Pageable pageable);

    void save(ProductBlock productBlock);

    ProductBlock findById(Integer id);

    void delete(ProductBlock productBlock);

    Page<ProductBlock> findAllByDate(String name, Pageable pageable);
}
