package com.example.controller;

import com.example.model.contract.AttachFacility;
import com.example.model.contract.Contract;
import com.example.model.contract.ContractDetail;
import com.example.service.contract.IAttachFacilityService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {

    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @GetMapping("")
    public String goListContractDetail(Model model, @PageableDefault(value = 4)Pageable pageable){
        Page<ContractDetail>contractDetailPage=iContractDetailService.findAll(pageable);
        model.addAttribute("contractDetailPage",contractDetailPage);
        return "/views/contractDetail/list";
    }

    @GetMapping("/create")
    public String showCreateContractDetail(Model model,@RequestParam Integer id){
        model.addAttribute("contractDetail",new ContractDetail());
        model.addAttribute("idContract",id);
        List<AttachFacility>attachFacilityList=iAttachFacilityService.findAll();
        List<Contract>contractList=iContractService.findAll();
        model.addAttribute("attachFacilityList",attachFacilityList);
        model.addAttribute("contractList",contractList);
        return "/views/contractDetail/create";
    }

    @PostMapping("/save")
    public String createContractDetail(ContractDetail contractDetail, RedirectAttributes redirectAttributes){
        iContractDetailService.save(contractDetail);
        redirectAttributes.addFlashAttribute("msg", "Add Completed contractDetail");
        return "redirect:/contractDetail";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        iContractDetailService.delete(iContractDetailService.findById(id));
        redirectAttributes.addFlashAttribute("msg", "Delete Completed contractDetail ");
        return "redirect:/contractDetail";
    }
}
