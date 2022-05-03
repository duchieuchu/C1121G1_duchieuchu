package com.codegym.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ConvertRepositoryImpl implements ConvertRepository{
    public Integer subtraction(Integer a, Integer b) {
        return a*b;
    }
}
