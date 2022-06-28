package com.example.service;

import com.example.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book>findAll(Pageable pageable);
    void save(Book book);
    void delete(Book book);
    Book findById(Integer id);
}
