package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class GreetingController {

    @GetMapping(value = "/goHomePage")
    public String goHomePage() {
        return "homePage";
    }

    @PostMapping(value = "/hello")
    public String hello(@RequestParam String name, Model model) {
        model.addAttribute("result",name);
        return "hello";
    }
}
