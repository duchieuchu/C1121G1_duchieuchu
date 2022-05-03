package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//annotation la controller
public class HelloController {
    @GetMapping("/hello")
    //su dung annotation getMapping de anh xa duong dan /hello den voi pt handle(co/hello thi pt handle se dc goi
    public String handle(Model model) {
model.addAttribute("message","hello word");
return "/index";
    }

}
