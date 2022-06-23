package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String list(Model model) {
        List<Blog> blogList = this.iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        this.iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id,Model model) {
        model.addAttribute("blog",this.iBlogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog){
        this.iBlogService.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String delete(Integer id){
        this.iBlogService.delete(this.iBlogService.findById(id));
        return "redirect:/blog";
    }
}
