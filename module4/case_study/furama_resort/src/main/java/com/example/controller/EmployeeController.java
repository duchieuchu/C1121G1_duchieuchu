package com.example.controller;

import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
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
    private IPositionService iPositionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;

    @RequestMapping("")
    public String list(Model model, @PageableDefault(value = 4) Pageable pageable,
                       @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        if (keyword.isPresent()) {
            Page<Employee> employeePage = iEmployeeService.getEmployeeByName(keywordVal, pageable);
            model.addAttribute("employeePage", employeePage);
            model.addAttribute("keywordVal", keywordVal);
        } else {
            Page<Employee> employeePage = iEmployeeService.findAll(pageable);
            model.addAttribute("employeePage", employeePage);
        }
        return "view/employee/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        List<Division> divisionList = iDivisionService.findAll();
        model.addAttribute("divisionList", divisionList);
        List<Position> positionList = iPositionService.findAll();
        model.addAttribute("positionList", positionList);
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        model.addAttribute("educationDegreeList", educationDegreeList);

        model.addAttribute("employee", new Employee());
        return "view/employee/create";
    }

    @PostMapping("save")
    public String save(Employee employee, RedirectAttributes redirectAttributes) {
        iEmployeeService.save(employee);
        redirectAttributes.addFlashAttribute("mess", "Add " + employee.getName() + " Completed");
        return "redirect:/employee/create";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", iEmployeeService.findById(id));
        List<Division> divisionList = iDivisionService.findAll();
        List<Position> positionList = iPositionService.findAll();
        List<EducationDegree> educationDegreeList = iEducationDegreeService.findAll();
        model.addAttribute("divisionList", divisionList);
        model.addAttribute("positionList", positionList);
        model.addAttribute("educationDegreeList", educationDegreeList);
        return "view/employee/edit";
    }

    @PostMapping("/update")
    public String update(Employee employee, RedirectAttributes redirectAttributes) {
        this.iEmployeeService.update(employee);
        redirectAttributes.addFlashAttribute("mess", "updated " + employee.getName() + " Completed");
        return "redirect:/employee";
    }

    @GetMapping("/delete")
    public String delete(Employee employee, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("mess", "delete Completed");
        this.iEmployeeService.delete(employee);
        return "redirect:/employee";
    }

    @GetMapping("/search")
    public String listSearch(@RequestParam String name, Model model, @PageableDefault(value = 4) Pageable pageable,
                             @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("keywordVal",keywordVal);
        Page<Employee> employeePage = iEmployeeService.getEmployeeByName(name, pageable);
        model.addAttribute("employeePage", employeePage);
        return "view/employee/list";
    }

}
