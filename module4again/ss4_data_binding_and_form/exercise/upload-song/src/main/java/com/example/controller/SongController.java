package com.example.controller;

import com.example.model.Song;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SongController {

    @GetMapping("/")
    public ModelAndView update(){
        ModelAndView modelAndView= new ModelAndView("/update","song",new Song());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute("song") Song song){
        ModelAndView modelAndView = new ModelAndView("/info");
        return modelAndView;
    }
}
