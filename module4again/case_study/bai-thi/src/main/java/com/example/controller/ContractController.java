package com.example.controller;

import com.example.model.Contract;
import com.example.service.IContractService;
import com.example.service.IRoomService;
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
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IRoomService iRoomService;
    @GetMapping("")
    public String goList(Model model, @PageableDefault(value = 4) Pageable pageable,
                         @RequestParam Optional<String> keyword){
        String keywordVal=keyword.orElse("");
        Page<Contract> contractPage=iContractService.findAllByName(keywordVal,pageable);
        model.addAttribute("contractPage",contractPage);
        model.addAttribute("keywordVal",keywordVal);
        return "views/contract/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model){
        model.addAttribute("contract",new Contract());
        model.addAttribute("roomList",iRoomService.findAll());
        return "views/contract/create";
    }

    @PostMapping("/save")
    public String create(Contract contract, RedirectAttributes redirectAttributes){
        iContractService.save(contract);
        redirectAttributes.addFlashAttribute("msg", "Add Completed contract have ID contract : " + contract.getContractCode());
        return "redirect:/contract";
    }

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

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id,RedirectAttributes redirectAttributes){
        iContractService.delete(iContractService.findById(id));
        redirectAttributes.addFlashAttribute("msg", "Delete Completed contract ");
        return "redirect:/contract";
    }
}
