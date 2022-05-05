package com.example.controller;

import com.example.model.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/medicalDeclaration")
public class MedicalDeclarationController {
    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String goShowForm(ModelMap modelMap) {
        modelMap.addAttribute("medicalDeclaration", new MedicalDeclaration());
        return "medicalDeclaration/create";
    }

    @RequestMapping(value = "/addMedicalDeclaration", method = RequestMethod.POST)
    public String submit(@ModelAttribute("medicalDeclaration") MedicalDeclaration medicalDeclaration, ModelMap modelMap) {
        modelMap.addAttribute("name", medicalDeclaration.getName());
        modelMap.addAttribute("dateOfBirth", medicalDeclaration.getDateOfBirth());
        modelMap.addAttribute("gender", medicalDeclaration.getGender());
        modelMap.addAttribute("national", medicalDeclaration.getNational());
        modelMap.addAttribute("idCard", medicalDeclaration.getIdCard());
        modelMap.addAttribute("travelInfo", medicalDeclaration.getTravelInfo());
        modelMap.addAttribute("numberPlate", medicalDeclaration.getNumberPlate());

        modelMap.addAttribute("seatNumber", medicalDeclaration.getSeatNumber());
        modelMap.addAttribute("startDay", medicalDeclaration.getStartDay());
        modelMap.addAttribute("endDay", medicalDeclaration.getEndDay());
        modelMap.addAttribute("localArrive", medicalDeclaration.getLocalArrive());
        modelMap.addAttribute("city", medicalDeclaration.getCity());
        modelMap.addAttribute("district", medicalDeclaration.getDistrict());
        modelMap.addAttribute("wards", medicalDeclaration.getWards());
        modelMap.addAttribute("address", medicalDeclaration.getAddress());
        modelMap.addAttribute("phone", medicalDeclaration.getPhone());
        modelMap.addAttribute("email", medicalDeclaration.getEmail());

        modelMap.addAttribute("fever", medicalDeclaration.getFever());
        modelMap.addAttribute("cough", medicalDeclaration.getCough());
        modelMap.addAttribute("shortOfBreath", medicalDeclaration.getShortOfBreath());
        modelMap.addAttribute("soreThroat", medicalDeclaration.getSoreThroat());
        modelMap.addAttribute("nausea", medicalDeclaration.getNausea());
        modelMap.addAttribute("diarrhea", medicalDeclaration.getDiarrhea());
        modelMap.addAttribute("hictory1", medicalDeclaration.getHictory1());
        modelMap.addAttribute("hictory2", medicalDeclaration.getHictory2());
        return "medicalDeclaration/info";
    }
}
