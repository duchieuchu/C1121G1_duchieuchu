package com.example.service;

import com.example.model.CardBorrow;

import java.util.List;

public interface ICardBorrowService {
    void save(CardBorrow cardBorrow);
    List<CardBorrow>findAll();
    CardBorrow findById();
    void deleteById(Integer id);
}
