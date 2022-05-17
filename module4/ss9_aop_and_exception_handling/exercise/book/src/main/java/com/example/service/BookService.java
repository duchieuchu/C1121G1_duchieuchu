package com.example.service;

import com.example.model.Book;
import com.example.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BookService implements IBookService {
    @Autowired
    private IBookRepository iBookRepository;


    @Override
    public Page<Book> getAll(Pageable pageable) {
        return this.iBookRepository.findAll(pageable);
    }

    @Override
    public Book getOne(Integer id) {
        return this.iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        this.iBookRepository.save(book);
    }

    @Override
    public void remove(Book book) {
        this.iBookRepository.delete(book);
    }
}
