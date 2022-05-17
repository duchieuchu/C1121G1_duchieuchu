package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBookService {
    Page<Book> getAll(Pageable pageable);

    Book getOne(Integer id);

    void save(Book book);
    void remove(Book book);
}
