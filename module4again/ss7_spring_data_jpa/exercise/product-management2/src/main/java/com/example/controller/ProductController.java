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
import org.springframework.web.bind.annotation.PathVariable;
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
    public String list(Model model, @PageableDefault(value = 2) Pageable pageable) {
        Page<Product> productPage = this.iProductService.findAll(pageable);
        model.addAttribute("productPage", productPage);
        return "/list";
    }

    @GetMapping("/add")
    public String showCreate(Model model) {
        List<Category> categoryList = this.iCategoryService.finaAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String create(Product product) {
        this.iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id){
        this.iProductService.delete(id);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Integer id,Model model){
        model.addAttribute("product",this.iProductService.findById(id));
        List<Category> categoryList = this.iCategoryService.finaAll();
        model.addAttribute("categoryList", categoryList);
        return "/edit";
    }

    @PostMapping("/update")
    public String edit(Product product){
        this.iProductService.update(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute("product",this.iProductService.findById(id));
        return "/view";
    }
}
