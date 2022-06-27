package com.example.controller;

import com.example.model.Category;
import com.example.model.Product;
import com.example.service.ICategoryService;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String page(Model model, @PageableDefault(value = 2)Pageable pageable){
        Page<Product>productPage=this.iProductService.findAll(pageable);
        model.addAttribute("productPage",productPage);
        List<Category>categoryList=iCategoryService.findAll();
        model.addAttribute("categoryList",categoryList);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(){
        return "/create";
    }

    @PostMapping("/add")
    public String create(){
        return "redirect:/product";
    }
}
