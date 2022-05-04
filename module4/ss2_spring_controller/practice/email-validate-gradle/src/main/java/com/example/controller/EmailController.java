package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class EmailController {
    private static final String REGEX_EMAIL = "^[\\w#][\\w\\.\\'+#](.[\\w\\\\'#]+)\\@[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*(.[a-zA-Z]{2,20})$";
    private static Pattern pattern;
    private Matcher matcher;

    public EmailController() {
        pattern = Pattern.compile(REGEX_EMAIL);
    }

    @GetMapping("/index")
    String getIndex() {
        return "index";
    }

    @PostMapping  ("/validate")
    String validateEmail(@RequestParam String email, Model model) {
        boolean isValid = this.validate(email);
        if (!isValid) {
            model.addAttribute("message", "email is invalid");
            return "index";
        }
        model.addAttribute("email", email);
        return "success";
    }

    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

}
