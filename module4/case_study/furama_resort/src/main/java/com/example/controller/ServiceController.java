package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.dto.ServiceDto;
import com.example.model.employee.Employee;
import com.example.model.service.RentType;
import com.example.model.service.Service;
import com.example.model.service.ServiceType;
import com.example.service.service.IRentTypeService;
import com.example.service.service.IServiceService;
import com.example.service.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        model.addAttribute("serviceTypeList", iServiceTypeService.findAll());
        model.addAttribute("rentTypeList",iRentTypeService.findAll());
        model.addAttribute("serviceDto", new ServiceDto());
        return "view/service/create";
    }

    @PostMapping("save")
    public String create(@ModelAttribute @Validated ServiceDto serviceDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,Model model){
        new ServiceDto().validate(serviceDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("serviceTypeList", iServiceTypeService.findAll());
            model.addAttribute("rentTypeList",iRentTypeService.findAll());
            return "view/service/create";
        }else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto,service);
            iServiceService.save(service);
            redirectAttributes.addFlashAttribute("mess",
                    "create service: "+service.getName() +" completed");
        }
        return "redirect:/service/create";
    }
//    @PostMapping("save")
//    public String save(Service service, RedirectAttributes redirectAttributes) {
//        iServiceService.save(service);
//        redirectAttributes.addFlashAttribute("mess", "Add " + service.getName() + " Completed");
//        return "redirect:/service/create";
//    }
    @GetMapping("/delete")
    public String delete(Service service, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "delete Completed");
        this.iServiceService.delete(service);
        return "redirect:/service";
    }

}
