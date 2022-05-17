package com.example.controller;

import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
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
    public CartDto initCart() {
        return new CartDto();
    }

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public ModelAndView showListPage(Model model, @CookieValue(value = "idProduct",
            defaultValue = "-1") Long idProduct) {
        if (idProduct != -1) {
            model.addAttribute("historyProduct", iProductService.findById(idProduct).get());
        }
        return new ModelAndView("product/list", "productList", iProductService.findAll());
    }
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable long id, HttpServletResponse response){
        Cookie cookie = new Cookie("idProduct",id+"");
        cookie.setMaxAge(60*60*24*1);//1 ngay
        cookie.setPath("/");
        response.addCookie(cookie);
        return  new ModelAndView("product/detail","product",
                iProductService.findById(id).get());
    }
    @GetMapping("add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cartDto){
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isPresent()){
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);

            //them product vao session cart
            cartDto.addProduct(productDto);
        }
        return "redirect:/cart";
    }
}
