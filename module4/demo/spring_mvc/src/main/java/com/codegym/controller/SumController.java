package com.codegym.controller;

import com.codegym.service.SumService;
import com.codegym.service.SumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SumController {
@Autowired
private  SumService sumService;
//    private final SumService sumService = new SumServiceImpl();
    @GetMapping(value = "/goHomePage")
    public String goHomePage(){
        return "home_page";
    }
    @PostMapping (value = "/sum")
    public String sum2Num(@RequestParam (name = "number1") Integer a,
                          @RequestParam (name = "number2") Integer b,
                          Model model){
//        Integer sum = a+b;
        model.addAttribute("result",this.sumService.sum(a,b));
        return "result_final";
    }
}

