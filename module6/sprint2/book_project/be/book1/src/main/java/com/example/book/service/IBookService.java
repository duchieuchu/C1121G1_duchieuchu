package com.example.book.service;


import com.example.book.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface IBookService {
    Page<Book> getAllPageBookByName(String bookName, Pageable pageable);

    Book saveBook(Book book);

    Book getBookById(Integer id);

    void deleteBookById(Integer id);

    void editBook(Book book);

    List<Book>getFiveBookByQuantitySmallest();

    List<Book>getFiveBookByQuantityLargest();
}
