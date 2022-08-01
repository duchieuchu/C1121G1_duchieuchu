package com.example.service;

import com.example.model.ProductBlock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductBlockService {
    Page<ProductBlock> findAll(Pageable pageable);

    List<ProductBlock> findAll();

    void save(ProductBlock productBlock);

    ProductBlock findById(Integer id);

    void delete(Integer id);

    Page<ProductBlock> findAllByDate(String name, Pageable pageable);
}
