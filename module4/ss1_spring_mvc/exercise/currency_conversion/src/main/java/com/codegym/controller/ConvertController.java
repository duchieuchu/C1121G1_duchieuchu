package com.codegym.controller;

import com.codegym.service.ConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertController {
    @Autowired
    private ConvertService sumService;
    //    private final SumService sumService = new SumServiceImpl();
    @GetMapping(value = "/convert")
    public String goHomePage(){
        return "home_page";
    }
    @PostMapping (value = "/subtraction")
    public String sum2Num(@RequestParam (name = "number1") Integer a,
                          @RequestParam (name = "number2") Integer b,
                          Model model){
//        Integer sum = a+b;
        model.addAttribute("result",this.sumService.subtraction(a,b));
        return "result_final";
    }
}
