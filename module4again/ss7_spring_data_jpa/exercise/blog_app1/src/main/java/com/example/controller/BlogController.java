package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String list(Model model, @PageableDefault(value = 2) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordVal=keyword.orElse("");
        model.addAttribute("blogPage",this.iBlogService.findAllByName(keywordVal,pageable));
        model.addAttribute("keywordVal",keywordVal);
//        Page<Blog> blogPage = this.iBlogService.findAll(pageable);
//        model.addAttribute("blogPage", blogPage);
        return "/list";
    }

    @GetMapping("/add")
    public String showCreate(Model model) {
        List<Category> categoryList = this.iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/create")
    public String create(Blog blog) {
        this.iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {
        this.iBlogService.delete(id);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        List<Category> categoryList = this.iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", this.iBlogService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog) {
        this.iBlogService.update(blog);
        return "redirect:/blog";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", this.iBlogService.findById(id));
        return "/view";
    }
}
