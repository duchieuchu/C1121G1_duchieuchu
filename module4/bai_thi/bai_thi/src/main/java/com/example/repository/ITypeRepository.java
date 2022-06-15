package com.example.repository;

import com.example.model.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITypeRepository extends JpaRepository<TypeProduct,Integer> {
}
