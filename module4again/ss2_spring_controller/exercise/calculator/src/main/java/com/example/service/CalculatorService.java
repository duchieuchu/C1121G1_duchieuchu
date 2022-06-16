package com.example.service;

import com.example.repository.ICalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    @Autowired
    private ICalculatorRepository iCalculatorRepository;
    @Override
    public Integer calculate(String calculate, Integer number1, Integer number2) {
        return this.iCalculatorRepository.calculate(calculate,number1,number2);
    }
}
