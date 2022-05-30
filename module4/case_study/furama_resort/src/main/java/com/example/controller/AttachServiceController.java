package com.example.controller;

import com.example.dto.ICustomerUseService;
import com.example.model.contract.ContractDetail;
import com.example.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/attachService")
public class AttachServiceController {
    @Autowired
    private ICustomerService iCustomerService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<ICustomerUseService> iCustomerUseServices = this.iCustomerService.findAllCustomerUserService(pageable);
        model.addAttribute("iCustomerUseServices", iCustomerUseServices);
        return "view/customer/customerList";
    }
}
