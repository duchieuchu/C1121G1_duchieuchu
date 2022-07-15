package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ContractController {
//    @Autowired

//    @GetMapping("")
//    public String goList(Model model, @PageableDefault(value = 4) Pageable pageable,
//                         @RequestParam Optional<String> keyword){
//        String keywordVal=keyword.orElse("");
//        Page<Customer> customerPage=iCustomerService.findAllByName(keywordVal,pageable);
//        model.addAttribute("customerPage",customerPage);
//        model.addAttribute("keywordVal",keywordVal);
//        return "views/customer/list";
//    }

//    @GetMapping("/create")
//    public String showCreate(Model model){
//        model.addAttribute("ghi vo",new Customer());
//        model.addAttribute("ghi vo",iCustomerTypeService.findAll());
//        return "views/customer/create";
//    }

//    @PostMapping("/save")
//    public String create(Customer ghi vo, RedirectAttributes redirectAttributes){
//        iCustomerService.save(customer);
//        redirectAttributes.addFlashAttribute("msg", "Add Completed customer: " + customer.getName());
//        return "redirect:/customer";
//    }

//    @GetMapping("/{id}/edit")
//    public String showEdit(@PathVariable Integer id, Model model){
//        model.addAttribute("ghi vo",iCustomerService.findById(id));
//        model.addAttribute("ghi vo",iCustomerTypeService.findAll());
//        return "views/customer/edit";
//    }

//    @PostMapping("/update")
//    public String edit(Customer ghi vo,RedirectAttributes redirectAttributes){
//        iCustomerService.save(customer);
//        redirectAttributes.addFlashAttribute("msg", "Edit Completed customer: " + customer.getName());
//        return "redirect:/customer";
//    }

//    @PostMapping("/delete")
//    public String delete(@RequestParam Integer id,RedirectAttributes redirectAttributes){
//        iCustomerService.delete(iCustomerService.findById(id));
//        redirectAttributes.addFlashAttribute("msg", "Delete Completed customer ");
//        return "redirect:/customer";
//    }
}
