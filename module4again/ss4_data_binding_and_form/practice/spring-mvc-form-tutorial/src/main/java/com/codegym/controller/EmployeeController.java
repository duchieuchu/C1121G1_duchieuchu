package com.codegym.controller;

import com.codegym.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @RequestMapping(value = "/showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee("1", "Ngoc Quang", "12"));
        return "employee/create";
    }

    @RequestMapping(value = "/addEmployee",method = RequestMethod.POST)
    public String addEmployee(Model model, @ModelAttribute("employee") Employee employee){
        model.addAttribute(employee);
        return "employee/info";
    }
}
