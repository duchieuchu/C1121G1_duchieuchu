package com.example.repository;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book b where  b.book_name like :bookName", nativeQuery = true,
            countQuery = "select * from book b where  b.book_name like :bookName")
    Page<Book> getPageBookByName(@Param("bookName") String bookName, Pageable pageable);
}
