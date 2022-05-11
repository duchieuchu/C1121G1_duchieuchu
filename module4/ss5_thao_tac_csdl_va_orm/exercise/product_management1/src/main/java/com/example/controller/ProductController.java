package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService IProductService;

    @GetMapping("")
    public String index(Model model) {
        List<Product> productList = IProductService.findAll();
        model.addAttribute("productList", productList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        IProductService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", IProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        IProductService.update(product.getId(), product);
        return "redirect:/product";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id) {
        Product product = this.IProductService.findById(id);
        this.IProductService.remove(product);
        return "redirect:/product";
    }
    //search
    @GetMapping("/search")
    public String search(@RequestParam String name, Model model) {
        List<Product> productList = IProductService.findByName(name);
        model.addAttribute("productList", productList);
        return "/index";
    }
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", IProductService.findById(id));
        return "/view";
    }


}
