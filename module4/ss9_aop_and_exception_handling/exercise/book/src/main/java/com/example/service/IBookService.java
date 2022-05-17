package com.example.service;

import com.example.model.Book;
import com.example.model.CardBorrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<Book> getAll(Pageable pageable);

    Book getOne(Integer id);

    void save(Book book);
    void remove(Book book);
}
