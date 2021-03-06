package com.example.controller;

import com.example.dto.ContractDto;
import com.example.model.contract.Contract;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.employee.IEmployeeService;
import com.example.service.service.IServiceService;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IServiceService iServiceService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Contract> contractPage = this.iContractService.findAll(pageable);
        model.addAttribute("contractPage", contractPage);
        return "view/contract/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("serviceList", iServiceService.findAll());
        model.addAttribute("contractDto", new ContractDto());
        return "view/contract/create";
    }

    @PostMapping("save")
    public String create(@ModelAttribute @Validated ContractDto contractDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes,Model model){
        new ContractDto().validate(contractDto,bindingResult);
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("employeeList", iEmployeeService.findAll());
            model.addAttribute("customerList", iCustomerService.findAll());
            model.addAttribute("serviceList", iServiceService.findAll());
            return "view/contract/create";
        }else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            iContractService.save(contract);
            redirectAttributes.addFlashAttribute("mess",
                    "create contract completed");
        }
        return "redirect:/contract/create";
    }
//    @PostMapping("save")
//    public String save(Contract contract, RedirectAttributes redirectAttributes) {
//        iContractService.save(contract);
//        redirectAttributes.addFlashAttribute("mess", "Add  Completed");
//        return "redirect:/contract/create";
//    }
    @GetMapping("/delete")
    public String delete(Contract contract, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "delete Completed");
        this.iContractService.delete(contract);
        return "redirect:/contract";
    }
}
