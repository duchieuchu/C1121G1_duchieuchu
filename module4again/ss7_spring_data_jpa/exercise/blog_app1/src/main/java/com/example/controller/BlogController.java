package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
//import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
//    @Autowired
//    private ICategoryService iCategoryService;

    @GetMapping("")
    public String list(Model model, @PageableDefault(value = 2) Pageable pageable) {
        Page<Blog> blogPage = this.iBlogService.findAll(pageable);
        model.addAttribute("blogPage", blogPage);
        return "/list";
    }
}
