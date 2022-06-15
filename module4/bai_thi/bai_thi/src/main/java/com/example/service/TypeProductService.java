package com.example.service;

import com.example.model.Product;
import com.example.model.TypeProduct;
import com.example.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TypeProductService implements ITypeProductService{
    @Autowired
    private ITypeRepository iTypeRepository;
    @Override
    public List<TypeProduct> findAll() {
        return iTypeRepository.findAll();
    }
    @Override
    public TypeProduct findById(Integer id) {
        return iTypeRepository.findById(id).orElse(null);
    }
}
