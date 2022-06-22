package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String goList(Model model) {
        List<Product> productList = this.iProductService.findAll();
        model.addAttribute("productList", productList);
        return "/list";
    }

    @GetMapping("/showCreateForm")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String create(Product product) {
        this.iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        Product product = this.iProductService.findById(id);
        this.iProductService.delete(product);
        return "redirect:/product";
    }

    @GetMapping("{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Product product){
        this.iProductService.update(product.getId1(),product);
        return "redirect:/product";
    }

}
