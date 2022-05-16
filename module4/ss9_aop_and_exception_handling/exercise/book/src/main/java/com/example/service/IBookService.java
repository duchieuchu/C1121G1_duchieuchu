package com.example.service;

import com.example.model.Book;
import com.example.model.CardBorrow;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    Book findById(Integer id);

    void reduceNumberOfBook(Book book);

    void copy(Book book, CardBorrow cardBorrow);

    void edit(Book book);

    void save(Book book);
}
