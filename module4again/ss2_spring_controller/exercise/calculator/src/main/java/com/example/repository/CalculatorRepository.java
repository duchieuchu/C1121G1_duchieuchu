package com.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepository implements ICalculatorRepository{
    @Override
    public Integer calculate(String calculate, Integer number1, Integer number2) {
        switch (calculate){
            case "Addition(+)":
                return number1+number2;
            case "Subtraction(-)":
                return number1-number2;
            case "Multiplication(x)":
                return number1*number2;
            case "Division(/)":
                if (number2==0){
                    return 0;
                }else{
                    return number1/number2;
                }
        }
        return -0;
    }
}
