package com.example.controller;

import com.example.dto.CustomerDto;
import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.service.customer.ICustomerService;
import com.example.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        if (keyword.isPresent()) {
            Page<Customer> customerPage = iCustomerService.getCustomerByInformation(keywordVal, pageable);
            model.addAttribute("customerPage", customerPage);
            model.addAttribute("keywordVal", keywordVal);
        } else {
            Page<Customer> customerPage = iCustomerService.findAll(pageable);
            model.addAttribute("customerPage", customerPage);
        }
        return "view/customer/list";
    }

//    @GetMapping("/create")
//    public String create(Model model) {
//        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
//        model.addAttribute("customerTypeList", customerTypeList);
//        model.addAttribute("customer", new Customer());
//        return "view/customer/create";
//    }

    //    @PostMapping("save")
//    public String save(Customer customer, RedirectAttributes redirectAttributes) {
//        iCustomerService.save(customer);
//        redirectAttributes.addFlashAttribute("mess", "Add " + customer.getName() + " Completed");
//        return "redirect:/customer/create";
//    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
        model.addAttribute("customerDto", new CustomerDto());
        return "view/customer/create";
    }

    @PostMapping("save")
    public String create(@ModelAttribute @Validated CustomerDto customerDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,Model model){
        new CustomerDto().validate(customerDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("customerTypeList", iCustomerTypeService.findAll());
            return "view/customer/create";
        }else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto,customer);
            iCustomerService.save(customer);
            redirectAttributes.addFlashAttribute("mess",
                    "create product: "+customer.getName() +" completed");
        }
        return "redirect:/customer/create";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", iCustomerService.findById(id));
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
        return "view/customer/edit";
    }

    @PostMapping("/update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        this.iCustomerService.update(customer);
        redirectAttributes.addFlashAttribute("mess", "updated " + customer.getName() + " Completed");
        return "redirect:/customer";
    }

    @GetMapping("/delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "delete Completed");
        this.iCustomerService.delete(customer);
        return "redirect:/customer";
    }

    @GetMapping("/search")
    public String listSearch(@RequestParam String name, Model model, @PageableDefault(value = 4) Pageable pageable,
                             @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("keywordVal", keywordVal);
        Page<Customer> customerPage = iCustomerService.getCustomerByName(name, pageable);
        model.addAttribute("customerPage", customerPage);
        return "view/customer/list";
    }

}
