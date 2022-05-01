package com.codegym.controller;

import com.codegym.service.TranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslateController {
    @Autowired
    private TranslateService translateService;

    @GetMapping("/goHomePage")
    public String goHomePage() {
        return "homePage";
    }

    @PostMapping("/translate")
    public String showResult(@RequestParam String vnm, Model model) {
        model.addAttribute("result", this.translateService.translate(vnm));
        return "result";
    }

}
