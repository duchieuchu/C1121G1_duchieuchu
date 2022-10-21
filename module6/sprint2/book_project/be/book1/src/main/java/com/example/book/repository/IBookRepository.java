package com.example.book.repository;

import com.example.book.models.Book;
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
public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book b where  b.book_name like :bookName and  b.is_deleted = 0 order by b.id desc", nativeQuery = true,
            countQuery = "select * from book b where  b.book_name like :bookName and b.is_deleted = 0 order by b.id desc")
    Page<Book> getPageBookByName(@Param("bookName") String bookName, Pageable pageable);

    @Query(value = "select * from book  where id=:id and is_deleted=0", nativeQuery = true)
    Book getBookById(@Param("id") Integer id);


    @Modifying
    @Query(value = "update book set is_deleted=1 where id =:id", nativeQuery = true)
    void deleteByBookId(@Param("id") Integer id);

    

}
