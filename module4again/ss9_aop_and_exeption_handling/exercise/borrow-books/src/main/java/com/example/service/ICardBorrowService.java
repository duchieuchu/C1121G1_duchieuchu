package com.example.service;

import com.example.model.CardBorrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICardBorrowService {
    Page<CardBorrow> findAll(Pageable pageable);

    void save(CardBorrow cardBorrow);

    CardBorrow findByCode(String code);

    void delete(CardBorrow cardBorrow);
}
