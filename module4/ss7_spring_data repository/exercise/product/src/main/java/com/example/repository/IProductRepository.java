package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value="select * from product where name like :name",nativeQuery=true)
    List<Product> searchByName(@Param("name")String name);

    Page<Product> findAllByNameContaining(String name, Pageable pageable);
}
