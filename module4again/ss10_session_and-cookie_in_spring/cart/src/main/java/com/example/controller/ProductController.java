package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String listProduct(Model model, @PageableDefault(value = 10) Pageable pageable) {
        Page<Product> productPage = iProductService.findAll(pageable);
        model.addAttribute("productPage", productPage);
        return "/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/add")
    public String create(Product product) {
        iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String goDetailProduct(@PathVariable Integer id,Model model) {
        model.addAttribute("product",iProductService.findById(id));
        return "/view";
    }
}
