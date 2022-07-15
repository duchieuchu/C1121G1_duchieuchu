package com.example.controller;

import com.example.model.contract.Contract;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
import com.example.service.customer.ICustomerService;
import com.example.service.employee.IEmployeeService;
import com.example.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    private IFacilityService iFacilityService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @GetMapping("")
    public String goListContract(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Contract> contractPage = iContractService.findAll(pageable);
        model.addAttribute("contractPage", contractPage);
        return "/views/contract/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("facilityList", iFacilityService.findAll());
        return "/views/contract/create";
    }

    @PostMapping("/save")
    public String createContract(Contract contract, RedirectAttributes redirectAttributes) {
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("msg", "Add Completed contract ");
        return "redirect:/contract";
    }

//    @GetMapping("/{id}/edit")
//    public String showEdit(@PathVariable Integer id, Model model) {
//        model.addAttribute("contract", iContractService.findById(id));
//        model.addAttribute("employeeList", iEmployeeService.findAll());
//        model.addAttribute("customerList", iCustomerService.findAll());
//        model.addAttribute("facilityList", iFacilityService.findAll());
//        return "/views/contract/edit";
//    }
//
//    @PostMapping("/update")
//    public String editContract(Contract contract, RedirectAttributes redirectAttributes) {
//        iContractService.save(contract);
//        redirectAttributes.addFlashAttribute("msg", "Edit Completed contract ");
//        return "redirect:/contract";
//    }

    @PostMapping("/delete")
    public String deleteContract(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        iContractService.delete(iContractService.findById(id));
        redirectAttributes.addFlashAttribute("msg", "Delete Completed contract ");
        return "redirect:/contract";
    }
}
