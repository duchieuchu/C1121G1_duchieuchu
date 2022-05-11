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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping("")
    public String list(Model model,@PageableDefault(value = 4,sort = {}) Pageable pageable,
                       @RequestParam Optional<String>keyword) {
        if (keyword.isPresent()){
            String keywordVal = keyword.orElse("");
            Page<Blog> blogList = iBlogService.getBlogByName(keywordVal,pageable);
            model.addAttribute("blogList", blogList);
            model.addAttribute("keywordVal",keywordVal);
        }else {
            String keywordVal = keyword.orElse("");
            Page<Blog> blogList = iBlogService.findAll(pageable);
            model.addAttribute("blogList", blogList);
            model.addAttribute("keywordVal",keywordVal);
        }

        return "list";
    }
//    @GetMapping("/search")
//    public String search(@RequestParam String name,Model model,@PageableDefault(value = 2,sort = {}) Pageable pageable,
//                         @RequestParam Optional<String>keyword) {
//        String keywordVal = keyword.orElse("");
//        Page<Blog> blogList = iBlogService.getBlogByName(name,pageable);
//        model.addAttribute("blogList", blogList);
//        model.addAttribute("keywordVal",keywordVal);
//        return "/list";
//    }
//    @RequestMapping("")
//    public String list(Model model) {
//        List<Blog> blogList = iBlogService.findAll();
//        model.addAttribute("blogList", blogList);
//        return "list";
//    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("blog", new Blog());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("mess", "Create blog Completed");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        List<Category> categoryList = iCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("mess", "Update blog Completed");
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.remove(blog);
        redirectAttributes.addFlashAttribute("mess", "Delete blog Completed");
        return "redirect:/blog";
    }

    //hien thi
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("category", iCategoryService.findById(id));

        return "/view";
    }
//    //search
//    @GetMapping("/search")
//    public String search(@RequestParam String name, Model model) {
//        List<Blog> blogList = iBlogService.findByName(name);
//        model.addAttribute("blogList", blogList);
//        return "/list";
//    }
}
