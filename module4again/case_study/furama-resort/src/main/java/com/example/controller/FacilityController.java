package com.example.controller;

import com.example.model.faciltity.Facility;
import com.example.model.faciltity.FacilityType;
import com.example.model.faciltity.RentType;
import com.example.service.IFacilityService;
import com.example.service.IFacilityTypeService;
import com.example.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/service")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("")
    public String goList(Model model, @PageableDefault(value = 4) Pageable pageable) {
        Page<Facility> facilityPage = this.iFacilityService.findAll(pageable);
        model.addAttribute("facilityPage", facilityPage);
        return "/views/facility/list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityTypeList", iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
        return "/views/facility/create";
    }

    @PostMapping("/save")
    public String create(Facility facility, RedirectAttributes redirectAttributes) {
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("msg", "Add Completed service: " + facility.getName());
        return "redirect:/service";
    }

    @GetMapping("/{id}/edit")
    public String showEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("facility", iFacilityService.findById(id));
        List<RentType> rentTypeList = iRentTypeService.findAll();
        List<FacilityType> facilityTypeList = iFacilityTypeService.findAll();
        model.addAttribute("rentTypeList", rentTypeList);
        model.addAttribute("facilityTypeList", facilityTypeList);
        return "/views/facility/edit";
    }

    @PostMapping("/update")
    public String showEdit(Facility facility, RedirectAttributes redirectAttributes) {
        iFacilityService.save(facility);
        redirectAttributes.addFlashAttribute("msg", "Edit Completed service: " + facility.getName());
        return "redirect:/service";
    }

    @GetMapping("/delete")
    public String delete(Facility facility,RedirectAttributes redirectAttributes){
        iFacilityService.delete(facility);
        redirectAttributes.addFlashAttribute("msg", "Delete Completed service ");
        return "redirect:/service";
    }
}
