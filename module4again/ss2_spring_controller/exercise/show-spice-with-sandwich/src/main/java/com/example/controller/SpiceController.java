package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpiceController {
    @RequestMapping("/")
    public String goHome() {
        return "/home";
    }

    @GetMapping("/getInfo")
    public String getInfo(@RequestParam String spice, Model model) {
        model.addAttribute("note","your sandwich have "+spice);
        return "/home";
    }
}
