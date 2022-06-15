package com.example.controller;

import com.example.service.ITranslatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private ITranslatorService iTranslatorService;

    @GetMapping("/home")
    public String goHome() {
        return "/home";
    }

    @GetMapping("/translate")
    public String translate(@RequestParam String english, Model model) {
        String vietnamese = this.iTranslatorService.translate(english);
        model.addAttribute("english",english);
        model.addAttribute("vietnamese",vietnamese);
        return "/result";
    }
}
