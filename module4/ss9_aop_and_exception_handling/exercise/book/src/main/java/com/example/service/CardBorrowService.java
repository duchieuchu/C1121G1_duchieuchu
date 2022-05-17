package com.example.service;

import com.example.model.Book;
import com.example.model.CardBorrow;
import com.example.repository.ICardBorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class CardBorrowService implements ICardBorrowService {
    @Autowired
    private ICardBorrowRepository iCardBorrowRepository;

    @Override
    public void save(CardBorrow cardBorrow) {
//        boolean check;
//        long code = 0;
//        do {
//            code = (long) (Math.random() * 89999 + 10000);
//            check = this.iCardBorrowRepository.existsByCode(Long.toString(code));
//        } while (check);
//        cardBorrow.setCode(Long.toString(code));
//        cardBorrow.setBorrowStartDate(LocalDate.now().toString());
        this.iCardBorrowRepository.save(cardBorrow);
    }

    @Override
    public boolean checkCode(String code) {
        return this.iCardBorrowRepository.existsByCode(code);
    }

    @Override
    public CardBorrow checkGiveBack(String code) {
        return this.iCardBorrowRepository.findByCode(code);
    }

    @Override
    public void remove(CardBorrow cardBorrow) {
        this.iCardBorrowRepository.delete(cardBorrow);
    }

}
