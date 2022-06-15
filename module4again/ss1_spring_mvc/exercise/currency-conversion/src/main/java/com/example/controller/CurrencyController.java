package com.example.controller;

import com.example.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyController {
    @Autowired
    private IConvertService iConvertService;

    @GetMapping("/home")
    public String showHome() {
        return "/home";
    }

    @PostMapping("/calculate")
    public String calculate(@RequestParam Integer usd, @RequestParam Integer rate, Model model) {
        model.addAttribute("usd", usd);
        Integer vnd = this.iConvertService.convert(rate, usd);
        model.addAttribute("vnd", vnd);
        return "/result";
    }

}
