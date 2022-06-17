package com.codegym.controller;

import com.codegym.dao.UserDao;
import com.codegym.model.Login;
import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("home")
    public String home(Model model) {
        model.addAttribute("login",new Login());
        return "home";
    }

//    @GetMapping("home")
//    public ModelAndView home() {
//        ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
//        return modelAndView;
//    }

//    @PostMapping("login")
//    public String login(@ModelAttribute("login") Login login, Model model){
//        User user = UserDao.checkLogin(login);
//        if(user == null){
//            return "error";
//        } else {
//            model.addAttribute("user",user);
//            return "user";
//        }
//    }
    @PostMapping("login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        User user = UserDao.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
