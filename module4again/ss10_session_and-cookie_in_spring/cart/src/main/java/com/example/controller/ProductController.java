package com.example.controller;

import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/product")
@SessionAttributes(value = {"cart"})
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute(value = "cart")
    public CartDto cartDto() {
        return new CartDto();
    }

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
    public String goDetailProduct(@PathVariable Integer id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "/view";
    }

    @GetMapping("/{id}/order")
    public String addProductToCart(@PathVariable Integer id, @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productOptional = Optional.ofNullable(iProductService.findById(id));
        if (productOptional.isPresent()) {
            ProductDto productDto= new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);

        }
        return "redirect:/cart";
    }
}
