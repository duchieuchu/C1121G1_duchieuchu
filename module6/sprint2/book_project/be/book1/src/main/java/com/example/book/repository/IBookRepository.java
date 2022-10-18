package com.example.book.repository;

import com.example.book.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book b where  b.book_name like :bookName and  b.is_deleted = 0", nativeQuery = true,
            countQuery = "select * from book b where  b.book_name like :bookName and b.is_deleted = 0")
    Page<Book> getPageBookByName(@Param("bookName") String bookName, Pageable pageable);

    @Query(value = "select * from book  where id=:id and is_deleted=0", nativeQuery = true)
    Book getBookById(@Param("id") Integer id);
}
