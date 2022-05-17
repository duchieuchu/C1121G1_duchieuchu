package com.example.service;

import com.example.model.CardBorrow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ICardBorrowService {
    Page<CardBorrow> getAll(Pageable pageable);
    void save(CardBorrow cardBorrow);

    boolean checkCode(String code);

    CardBorrow checkGiveBack(String code);
    void remove(CardBorrow cardBorrow);
}
