package com.example.repository;

import org.springframework.stereotype.Repository;

@Repository
public class CalculatorRepositoryImpl implements CalculatorRepository {
    @Override
    public Integer calculate(Integer number1, Integer number2, String calculator) {
        switch (calculator) {
            case "Addition(+)":
                return number1 + number2;
            case "Subtraction(-)":
                return number1 - number2;
            case "Multiplication(X)":
                return number1 * number2;
            case "Division(/)":
                if (number2 != 0) {
                    return number1 / number2;
                } else {
                    return 0;
                }
        }
        return -0;
    }
}
