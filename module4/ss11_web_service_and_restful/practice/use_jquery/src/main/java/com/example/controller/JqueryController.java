package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/text")
public class JqueryController {
    @GetMapping("")
    public String text() {
        return "hide_and_show";
    }
}
