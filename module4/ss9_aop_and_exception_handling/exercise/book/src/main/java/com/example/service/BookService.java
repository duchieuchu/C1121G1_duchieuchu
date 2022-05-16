package com.example.service;

import com.example.model.Book;
import com.example.model.CardBorrow;
import com.example.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository iBookRepository;
    @Override
    public List<Book> findAll() {
        return this.iBookRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return this.iBookRepository.findById(id).orElse(null);
    }

    @Override
    public void reduceNumberOfBook(Book book) {
        int borrowedTotalNew = book.getBorrowedTotal() + 1;
        int remainTotalNew = book.getQuantityTotal() - borrowedTotalNew;
        book.setBorrowedTotal(borrowedTotalNew);
        book.setRemainTotal(remainTotalNew);
        iBookRepository.save(book);
    }

    @Override
    public void copy(Book book, CardBorrow cardBorrow) {
        cardBorrow.setCode((int) (10000 + (Math.random() * 99999)));
    }


    @Override
    public void edit(Book book) {

    }

    @Override
    public void save(Book book) {

    }
}
