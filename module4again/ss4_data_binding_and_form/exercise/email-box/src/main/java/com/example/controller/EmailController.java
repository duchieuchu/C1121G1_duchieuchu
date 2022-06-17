package com.example.controller;

import com.example.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {

    @GetMapping("/")
    public ModelAndView goHome(){
        ModelAndView modelAndView = new ModelAndView("/home","update", new Email());
        return  modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("email") Email email){
        ModelAndView modelAndView = new ModelAndView("/info");
//        modelAndView.addObject("email",email);
        return modelAndView;
    }

}
