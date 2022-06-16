package com.example.controller;

import com.example.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
@Autowired
private ICalculatorService iCalculatorService;
    @GetMapping("/")
    public String goHome() {
        return "/home";
    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam String calculate, @RequestParam Integer number1,
                             @RequestParam Integer number2,Model model) {
        Integer result = this.iCalculatorService.calculate(calculate,number1,number2);
        System.out.println(number1);
        model.addAttribute("result","result: "+result);
        return "/home";
    }
}
