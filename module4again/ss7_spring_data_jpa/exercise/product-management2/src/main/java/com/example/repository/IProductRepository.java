package com.example.repository;

import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = " select * from product", nativeQuery = true)
    Page<Product> selectList(Pageable pageable);

    @Query(value = " select * from product p where p.id1 =:idP", nativeQuery = true)
    Product selectProductById(@Param("idP") Integer id);

    @Modifying
    @Query(value = " delete from product p where p.id1 =:idP", nativeQuery = true)
    int deleteBlogById(@Param("idP") Integer id);

    @Modifying
    @Query(value="insert into product (name1, info1, quantity1,made1,category_id) VALUES (:name ,:info, :quantity, :made,:category) ",nativeQuery = true)
    int createProduct(@Param("name") String name, @Param("info") String info, @Param("quantity") Integer quantity, @Param("made") String made,@Param("category") Integer category);

    @Modifying
    @Query(value="update product set name1=:name,info1=:info,quantity1=:quantity,made1=:made,category_id=:category where id1=:id",nativeQuery = true)
    int updateBlog(@Param("name") String name, @Param("info") String info, @Param("quantity") Integer quantity, @Param("made") String made,@Param("category") Integer category,@Param("id") Integer id);

}
