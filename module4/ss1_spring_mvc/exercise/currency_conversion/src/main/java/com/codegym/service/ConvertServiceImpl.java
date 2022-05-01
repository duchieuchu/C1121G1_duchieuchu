package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {
    @Override
    public Integer sum(Integer a, Integer b) {
        return a*b;
    }
}
