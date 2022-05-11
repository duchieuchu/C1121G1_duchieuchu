package com.example.controller;

import com.example.model.Product;
import com.example.service.IProductService;
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
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4, sort = {}) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        if (keyword.isPresent()){
            String keywordVal = keyword.orElse("");
            Page<Product> productList = iProductService.getProductByName(keywordVal,pageable);
            model.addAttribute("productList", productList);
            model.addAttribute("keywordVal",keywordVal);
        }else {
            String keywordVal = keyword.orElse("");
            Page<Product> productList = iProductService.findAll(pageable);
            model.addAttribute("productList", productList);
            model.addAttribute("keywordVal",keywordVal);
        }
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList", productList);
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("mess", "Create product Completed");
        return "redirect:/product";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product);
        redirectAttributes.addFlashAttribute("mess", "Update product Completed");
        return "redirect:/product";
    }
    @GetMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.remove(product);
        redirectAttributes.addFlashAttribute("mess", "Delete product Completed");
        return "redirect:/product";
    }
    //hien thi
    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));

        return "/view";
    }
}
