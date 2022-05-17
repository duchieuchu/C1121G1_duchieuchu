package com.example.service;

import com.example.model.CardBorrow;


public interface ICardBorrowService {
    void save(CardBorrow cardBorrow);

    boolean checkCode(String code);

    CardBorrow checkGiveBack(String code);
    void remove(CardBorrow cardBorrow);
}
