package com.example.controller;

import com.example.model.customer.Customer;
import com.example.model.customer.CustomerType;
import com.example.model.service.RentType;
import com.example.model.service.Service;
import com.example.model.service.ServiceType;
import com.example.service.service.IRentTypeService;
import com.example.service.service.IServiceService;
import com.example.service.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService iServiceService;
    @Autowired
    private IServiceTypeService iServiceTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Service> servicePage = this.iServiceService.findAll(pageable);
        model.addAttribute("servicePage", servicePage);
        return "view/service/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<ServiceType> serviceTypeList = iServiceTypeService.findAll();
        model.addAttribute("serviceTypeList", serviceTypeList);

        List<RentType> rentTypeList = iRentTypeService.findAll();
        model.addAttribute("rentTypeList", rentTypeList);

        model.addAttribute("customer", new Customer());
        return "view/service/create";
    }

    @PostMapping("save")
    public String save(Service service, RedirectAttributes redirectAttributes) {
        iServiceService.save(service);
        redirectAttributes.addFlashAttribute("mess", "Add " + service.getName() + " Completed");
        return "redirect:/service/create";
    }

}
