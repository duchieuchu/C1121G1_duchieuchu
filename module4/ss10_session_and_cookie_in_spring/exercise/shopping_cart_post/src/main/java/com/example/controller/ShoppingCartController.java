package com.example.controller;

import com.example.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
        @RequestMapping("")
    public ModelAndView showCart(@SessionAttribute(name = "cart", required = false) CartDto cartDto) {
        return new ModelAndView("cart", "cart", cartDto);
    }

//    @GetMapping
//    public String show(@SessionAttribute(name = "cart", required = false) CartDto cartDto,
//                       Model model) {
//        model.addAttribute("cart", cartDto);
//        return "cart";
//    }
}
