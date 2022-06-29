package com.example.repository;

import com.example.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Modifying
    @Query(value = "update book set quantity= (quantity - 1) where id=:id", nativeQuery = true)
    int updateQuantityDown( @Param("id") Integer id);

    @Modifying
    @Query(value = "update book set quantity= (quantity + 1) where id=:id", nativeQuery = true)
    int updateQuantityUp( @Param("id") Integer id);


}
