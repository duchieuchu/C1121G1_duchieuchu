package com.example.controller;

import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import com.example.model.faciltity.FacilityType;
import com.example.model.faciltity.RentType;
import com.example.service.employee.IDivisionService;
import com.example.service.employee.IEducationDegreeService;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IDivisionService iDivisionService;

    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @Autowired
    private IPositionService iPositionService;

    @GetMapping("")
    public String goListEmployee(Model model, @PageableDefault(value = 4) Pageable pageable,
                                 @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        Page<Employee> employeePage = iEmployeeService.findAllByName(keywordVal, pageable);
        model.addAttribute("employeePage", employeePage);
        model.addAttribute("keywordVal", keywordVal);
        model.addAttribute("employee", new Employee());
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());

        return "/views/employee/list";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, RedirectAttributes redirectAttributes) {
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Add Completed employee: " + employee.getName());
        return "redirect:/employee";
    }

    @PostMapping("/update")
    public String editEmployee(RedirectAttributes redirectAttributes,
                               @RequestParam Integer id,
                               @RequestParam String name,
                               @RequestParam String dateOfBirth,
                               @RequestParam String idCard,
                               @RequestParam Double salary,
                               @RequestParam String phoneNumber,
                               @RequestParam String email,
                               @RequestParam String address,
                               @RequestParam Position position,
                               @RequestParam EducationDegree educationDegree,
                               @RequestParam Division division) {

        Employee employee = new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, position, educationDegree, division);
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("msg", "Edit Completed employee: " + employee.getName());
        return "redirect:/employee";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        iEmployeeService.delete(iEmployeeService.findById(id));
        redirectAttributes.addFlashAttribute("msg", "Delete Completed employee ");
        return "redirect:/employee";
    }
}
