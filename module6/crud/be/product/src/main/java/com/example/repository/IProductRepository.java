package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Transactional
    @Modifying
    @Query(value = "update product p " +
            "set is_deleted = 1 " +
            "where  p.id =:idProduct and p.is_deleted = 0", nativeQuery = true)
    int deleteProduct(@Param("idProduct") Integer id);

    @Query(value = "select * from product where is_deleted = 0", nativeQuery = true)
    Page<Product> getPageProduct(Pageable pageable);

    @Query(value = " SELECT * FROM product where is_deleted = 0 ",
            nativeQuery = true, countQuery = " select count(*) from ( SELECT * FROM product where is_deleted = 0 ) temp_table ")
    Page<Product> selectAllProductPage(Pageable pageable);


}
