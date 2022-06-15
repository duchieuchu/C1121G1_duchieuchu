package com.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ConvertRepository implements IConvertRepository {
    @Override
    public Integer convert(Integer rate, Integer usd) {
        return rate * usd;
    }
}
