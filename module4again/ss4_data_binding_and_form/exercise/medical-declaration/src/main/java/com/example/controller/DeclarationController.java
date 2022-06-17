package com.example.controller;

import com.example.model.Declaration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeclarationController {

    @GetMapping("/")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/create", "declaration", new Declaration());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView info(@ModelAttribute("declaration") Declaration declaration) {
        ModelAndView modelAndView = new ModelAndView("/info");
        return modelAndView;
    }
}
