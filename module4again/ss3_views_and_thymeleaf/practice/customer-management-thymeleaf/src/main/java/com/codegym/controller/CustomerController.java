package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    //hien trang list
    @GetMapping("")
    public String goHome(Model model) {
        List<Customer> customerList = this.iCustomerService.findAll();
        model.addAttribute("customerList", customerList);
        return "/home";
    }

    // show create
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "/create";
    }

    //create
    @PostMapping("/save")
    public String addCustomer(@ModelAttribute Customer customer) {
        this.iCustomerService.add(customer);
        return "redirect:/customer";
    }

    //xoa
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id) {
        this.iCustomerService.delete(id);
        return "redirect:/customer";
    }

    //showUpdateForm
    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", this.iCustomerService.findById(id));
        return "/edit";
    }

    //edit v
    @PostMapping("/edit")
    public String edit(Customer customer){
        this.iCustomerService.update(customer.getId(),customer);
        return "redirect:/customer";
    }
    //chi tiet
    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute("customer",this.iCustomerService.findById(id));
        return "/view";
    }

}
