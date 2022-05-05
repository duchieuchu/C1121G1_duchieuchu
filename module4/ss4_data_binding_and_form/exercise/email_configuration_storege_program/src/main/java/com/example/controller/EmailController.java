package com.example.controller;

import com.example.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/email")
public class EmailController {
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String goSetting(ModelMap modelMap) {
        modelMap.addAttribute("email", new Email());
        return "setting";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String submit(@ModelAttribute("email") Email email, ModelMap modelMap) {
        modelMap.addAttribute("language", email.getLanguage());
        modelMap.addAttribute("pageSize", email.getPageSize());
        modelMap.addAttribute("spamsFilter", email.isSpamsFilter());
        modelMap.addAttribute("signNature", email.getSignNature());
        return "info";
    }
}
