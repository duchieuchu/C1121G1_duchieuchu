package com.example.controller;

import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class ControllerBlog {
    @Autowired
    private IBlogService IBlogService;

    @RequestMapping("")
    public String list(Model model) {
        List<Blog> blogList = IBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog,RedirectAttributes redirectAttributes) {
        IBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess","Create blog Completed");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", IBlogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update( Blog blog, RedirectAttributes redirectAttributes) {
        IBlogService.update(blog);
        redirectAttributes.addFlashAttribute("mess","Update blog Completed");
        return "redirect:/blog";
    }
    @GetMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        this.IBlogService.remove(blog);
        redirectAttributes.addFlashAttribute("mess", "Delete blog Completed");
        return "redirect:/blog";
    }
    //hien thi
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", IBlogService.findById(id));
        return "/view";
    }
    //search
    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Blog> blogList = IBlogService.findByName(name);
        model.addAttribute("blogList", blogList);
        return "/list";
    }
}
