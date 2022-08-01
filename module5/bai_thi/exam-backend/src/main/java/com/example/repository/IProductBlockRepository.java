package com.example.repository;

import com.example.model.ProductBlock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductBlockRepository extends JpaRepository<ProductBlock,Integer> {
}
