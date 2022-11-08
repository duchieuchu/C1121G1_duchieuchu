package com.example.book.service.impl;

import com.example.book.models.Book;
import com.example.book.repository.IBookRepository;
import com.example.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;




//@Service
@Component
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;

    @Override
    public Page<Book> getAllPageBookByName(String bookName, Pageable pageable) {
        return this.iBookRepository.getPageBookByName("%" + bookName + "%", pageable);
    }


    @Override
    public Book saveBook(Book book) {
        return this.iBookRepository.save(book);
    }

    @Override
    public Book getBookById(Integer id) {
        return this.iBookRepository.getBookById(id);
    }

    @Override
    public void deleteBookById(Integer id) {
        this.iBookRepository.deleteByBookId(id);
    }

    @Override
    public void editBook(Book book) {
        this.iBookRepository.save(book);
    }


}
