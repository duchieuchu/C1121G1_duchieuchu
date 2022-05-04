package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping(value = "/sandwich")
    public String goSandwich(){
        return "sandwich";
    }
    @PostMapping(value = "/sandwich")
    public String save(@RequestParam String[] spice, Model model){
        model.addAttribute("spice",spice);
        return "sandwich";
    }
}
