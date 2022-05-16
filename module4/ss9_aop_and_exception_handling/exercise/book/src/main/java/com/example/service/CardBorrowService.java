package com.example.service;

import com.example.model.CardBorrow;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardBorrowService implements ICardBorrowService{
    @Override
    public void save(CardBorrow cardBorrow) {

    }

    @Override
    public List<CardBorrow> findAll() {
        return null;
    }

    @Override
    public CardBorrow findById() {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
