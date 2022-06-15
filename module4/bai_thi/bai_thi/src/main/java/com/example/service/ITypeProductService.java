package com.example.service;

import com.example.model.TypeProduct;

import java.util.List;

public interface ITypeProductService {
    List<TypeProduct> findAll();

    TypeProduct findById(Integer id);
}
