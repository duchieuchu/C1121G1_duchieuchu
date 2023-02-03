package com.example.repository;

import com.example.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "select * from product p where p.is_deleted = 0 ;", nativeQuery = true)
    List<Product> getAllProduct();


    @Transactional
    @Modifying
    @Query(value = " update product p set is_deleted = 1 where  p.id =:productId and p.is_deleted = 0", nativeQuery = true)
    int deleteProductById(@Param("productId") Integer id);

    @Transactional
    @Modifying
    @Query(value = "insert into blog (name, content, note) VALUES (:name ,:content, :note) ", nativeQuery = true)
    int createBlog(@Param("name") String name, @Param("content") String content, @Param("note") String note);

    @Query(value = "INSERT INTO product (`code`," +
            " `gas`," +
            " `import_date`," +
            " `made`," +
            " `name`," +
            " `price`," +
            " `status`," +
            " `category_id`) " +
            "VALUES (:code," +
            " :gas," +
            " :importDate," +
            " :made," +
            " :name," +
            " :price," +
            " :status," +
            " :categoryId);", nativeQuery = true)
    int createBlog(@Param("code") String code,
                   @Param("gas") Boolean gas,
                   @Param("importDate") String importDate,
                   @Param("importDate") String importDate,
                   @Param("importDate") String importDate,
                   @Param("importDate") String importDate,
                   @Param("importDate") String importDate,
                   @Param("importDate") String importDate,
                   @Param("importDate") String importDate,
                   @Param("importDate") String importDate,
                   @Param("importDate") String importDate,
                   );

}
