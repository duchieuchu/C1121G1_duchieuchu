package com.codegym.service;

import com.codegym.repository.ConvertRepository;
import com.codegym.repository.ConvertRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements ConvertService {
    @Autowired
    private  ConvertRepository convertRepository;
//    private final ConvertRepository convertRepository = new ConvertRepositoryImpl();
    @Override
    public Integer subtraction(Integer a, Integer b) {
        return convertRepository.subtraction(a,b);
    }
}
