package com.example.controller;

import com.example.model.contract.AttachService;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.service.Service;
import com.example.service.contract.IAttachServiceService;
import com.example.service.contract.IContractDetailService;
import com.example.service.contract.IContractService;
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
@RequestMapping("/contractDetail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IAttachServiceService iAttachServiceService;
    @Autowired
    private IContractService iContractService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<ContractDetail> contractDetailPage = this.iContractDetailService.findAll(pageable);
        model.addAttribute("contractDetailPage", contractDetailPage);
        return "view/contractDetail/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<AttachService> attachServiceList = iAttachServiceService.findAll();
        model.addAttribute("attachServiceList", attachServiceList);

        List<Contract> contractList = iContractService.findAll();
        model.addAttribute("contractList", contractList);

        model.addAttribute("contractDetail", new ContractDetail());
        return "view/contractDetail/create";
    }

    @PostMapping("save")
    public String save(ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        iContractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("mess", "Add  Completed");
        return "redirect:/contractDetail/create";
    }

    @GetMapping("/delete")
    public String delete(ContractDetail contractDetail, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "delete Completed");
        this.iContractDetailService.delete(contractDetail);
        return "redirect:/contractDetail";
    }
}
