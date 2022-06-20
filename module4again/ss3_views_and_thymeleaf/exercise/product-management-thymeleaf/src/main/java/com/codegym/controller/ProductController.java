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
    public String goHome(Model model) {
        List<Product> productList = this.iProductService.findAll();
        model.addAttribute("productList", productList);
        return "/home";
    }

    @GetMapping("/showCreateForm")
    public String showCreate(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create")
    public String create(Product product) {
        this.iProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id) {
        this.iProductService.delete(id);
        return "redirect:/product";
    }

    //showUpdateForm
    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/edit";
    }

    //edit v
    @PostMapping("/edit")
    public String edit(Product product) {
        this.iProductService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "/view";
    }


    @GetMapping("/search")
    public String listSearch(Model model,@RequestParam String name) {
        List<Product> productList = this.iProductService.findAllByName(name);
        model.addAttribute("productList", productList);
        return "/home";
    }
}
