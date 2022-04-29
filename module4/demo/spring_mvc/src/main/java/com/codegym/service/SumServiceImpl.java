package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class SumServiceImpl implements SumService{
    @Override
    public Integer sum(Integer a, Integer b) {
        return a+b;
    }
}
