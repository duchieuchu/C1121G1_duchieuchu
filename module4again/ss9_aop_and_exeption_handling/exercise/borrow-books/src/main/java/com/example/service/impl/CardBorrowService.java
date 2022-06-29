package com.example.service.impl;

import com.example.model.CardBorrow;
import com.example.repository.ICardBorrowRepository;
import com.example.service.ICardBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CardBorrowService implements ICardBorrowService {
    @Autowired
    private ICardBorrowRepository iCardBorrowRepository;

    @Override
    public Page<CardBorrow> findAll(Pageable pageable) {
        return iCardBorrowRepository.findAll(pageable);
    }

    @Override
    public void save(CardBorrow cardBorrow) {
        iCardBorrowRepository.save(cardBorrow);
    }

    @Override
    public CardBorrow findByCode(String code) {
        return iCardBorrowRepository.findByCode(code);
    }


    @Override
    public void delete(CardBorrow cardBorrow) {
        iCardBorrowRepository.delete(cardBorrow);
    }
}
