package com.example.repository;

import com.example.model.Base;
import com.example.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Repository
public interface IBaseRepository extends JpaRepository<Base, Integer> {

//    @Query(value = " SELECT * FROM base where is_deleted = 0  and name like :name",
//            nativeQuery = true, countQuery = " select count(*) from ( SELECT * FROM base where is_deleted = 0  and name like :name ) temp_table ")
//    List<Base> selectAllProductPage(@Param("name") String name, Pageable pageable);

    @Query(value = " SELECT * FROM base where is_deleted = 0 and name like :name",
            nativeQuery = true, countQuery = " select count(*) from ( SELECT * FROM base where is_deleted = 0 and name like :name ) temp_table ")
    List<Base> searchList(@Param("name") String name);

    @Query(value = " SELECT * FROM base where is_deleted = 0 ",
            nativeQuery = true, countQuery = " select count(*) from ( SELECT * FROM base where is_deleted = 0 ) temp_table ")
    List<Base> getList();

    @Transactional
    @Modifying
    @Query(value = "update base b " +
            "set is_deleted = 1 " +
            "where  b.id =:idBase and b.is_deleted = 0", nativeQuery = true)
    int deleteProduct(@Param("idBase") Integer id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `base` (`address`," +
            "`base_code`," +
            "`name`," +
            " `open_day`," +
            " `employee_id`) " +
            " VALUES (:#{#base.address}," +
            ":#{#base.baseCode}," +
            ":#{#base.name}," +
            ":#{#base.openDay}," +
            ":#{#base.employee});", nativeQuery = true)
    void createBase(Base base);
}
