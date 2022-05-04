package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping(value ="/homePage")
    public String goCalculator() {
        return "calculator";
    }

    @GetMapping(value = "/calculator")
    public String calculate(@RequestParam Integer number1, @RequestParam Integer number2,@RequestParam String calculator, Model model) {
      model.addAttribute("show","Result is ");
        model.addAttribute("result", this.calculatorService.calculate(number1, number2, calculator));
        return "calculator";
    }

}
