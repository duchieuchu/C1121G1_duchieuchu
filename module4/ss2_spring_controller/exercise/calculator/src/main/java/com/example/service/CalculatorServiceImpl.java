package com.example.service;

import com.example.repository.CalculatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService{
    @Autowired
    private CalculatorRepository calculatorRepository;
    @Override
    public Integer calculate(Integer number1, Integer number2, String calculator) {
        return calculatorRepository.calculate(number1,number2,calculator);
    }
}
