package com.example.controller;

import com.example.model.Order;
import com.example.model.Product;
import com.example.service.IOrderService;
import com.example.service.IProductService;
import com.example.service.ITypeProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OderController {
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private IProductService iProductService;
    @Autowired
    private ITypeProductService iTypeProductService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Order> orderPage = iOrderService.findAll(pageable);
//        model.addAttribute("productList",iProductService.findAll());
//        model.addAttribute("typeProduct",iProductService.findAll());
        model.addAttribute("orderPage", orderPage);
        return "list";
    }

}
