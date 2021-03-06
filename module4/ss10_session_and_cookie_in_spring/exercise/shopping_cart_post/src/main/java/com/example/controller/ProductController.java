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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@SessionAttributes("cart")// khai bao sesion
@Controller
@RequestMapping("/shop")
public class ProductController {
    //khoi tao gia tri default
    @ModelAttribute("cart")
    public CartDto cartDto() {
        return new CartDto();
    }

    @Autowired
    private IProductService iProductService;
    @GetMapping("")
    public String listProduct(@PageableDefault(value = 10) Pageable pageable, Model model){
        Page<Product> products = this.iProductService.findAll(pageable);
        model.addAttribute("products",products);
        return "list";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Integer id, HttpServletResponse response){
        Cookie cookie = new Cookie("idProduct",id+"");
        cookie.setMaxAge(60*60*24*1);//1 ngay
        cookie.setPath("/");
        response.addCookie(cookie);
        return  new ModelAndView("product/detail","product",
                iProductService.findById(id));
    }
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Integer id,
                            @SessionAttribute("cart") CartDto cartDto){
        Optional<Product> productOptional = Optional.ofNullable(iProductService.findById(id));
        if (productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);

            //them product vao session car ben cardDto
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/sub/{id}")
    public String subToCart(@PathVariable Integer id,
                            @SessionAttribute("cart") CartDto cartDto) {
        Optional<Product> productOptional = Optional.ofNullable(iProductService.findById(id));
        if (productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);
            cartDto.subProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/pay")
    public String pay(@SessionAttribute("cart") CartDto cartDto){
        cartDto.deleteAll();
        return "redirect:/cart";
    }
}
