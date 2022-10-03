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
    public Page<Book> getAllPageBookByName(String bookName, Pageable pageable) {
        return this.iBookRepository.getPageBookByName("%" + bookName + "%", pageable);
    }
}
