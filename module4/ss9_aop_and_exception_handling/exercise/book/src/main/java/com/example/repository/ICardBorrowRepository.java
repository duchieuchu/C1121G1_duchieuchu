package com.example.repository;

import com.example.model.CardBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardBorrowRepository extends JpaRepository<CardBorrow, Integer> {
    boolean existsByCode(String code);
    CardBorrow findByCode(String code);
}
