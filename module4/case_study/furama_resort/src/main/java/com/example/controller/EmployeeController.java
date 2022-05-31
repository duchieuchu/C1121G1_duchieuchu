package com.example.controller;

import com.example.dto.EmployeeDto;
import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Employee;
import com.example.model.employee.Position;
import com.example.service.employee.IDivisionService;
import com.example.service.employee.IEducationDegreeService;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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
                       @RequestParam Optional<String> keyword,
                       @RequestParam Optional<String> divisionQuery
                       ) {
        String keywordVal = keyword.orElse("");
        String division = divisionQuery.orElse("");
        model.addAttribute("divisionList", iDivisionService.findAll());
        if (keyword.isPresent() || divisionQuery.isPresent()) {
            Page<Employee> employeePage = iEmployeeService.getEmployeeByInformation(keywordVal,division, pageable);

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
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
        model.addAttribute("employeeDto", new EmployeeDto());
        return "view/employee/create";
    }

    @PostMapping("save")
    public String create(@ModelAttribute @Validated EmployeeDto employeeDto,
                         BindingResult bindingResult,
                         RedirectAttributes redirectAttributes, Model model) {
        new EmployeeDto().validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("divisionList", iDivisionService.findAll());
            model.addAttribute("positionList", iPositionService.findAll());
            model.addAttribute("educationDegreeList", iEducationDegreeService.findAll());
            return "view/employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            iEmployeeService.save(employee);
            redirectAttributes.addFlashAttribute("mess",
                    "create product: " + employee.getName() + " completed");
        }
        return "redirect:/employee/create";
    }

//    @PostMapping("save")
//    public String save(Employee employee, RedirectAttributes redirectAttributes) {
//        iEmployeeService.save(employee);
//        redirectAttributes.addFlashAttribute("mess", "Add " + employee.getName() + " Completed");
//        return "redirect:/employee/create";
//    }

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

    //    @GetMapping("/search")
//    public String listSearch(@RequestParam String name, Model model, @PageableDefault(value = 4) Pageable pageable,
//                             @RequestParam Optional<String> keyword) {
//        String keywordVal = keyword.orElse("");
//        model.addAttribute("keywordVal",keywordVal);
//        Page<Employee> employeePage = iEmployeeService.getEmployeeByName(name, pageable);
//        model.addAttribute("employeePage", employeePage);
//        return "view/employee/list";
//    }
    //hien thi
    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("employee", iEmployeeService.findById(id));
        model.addAttribute("divisionList", iDivisionService.findById(id));
        model.addAttribute("positionList", iPositionService.findById(id));
        model.addAttribute("educationDegreeList", iEducationDegreeService.findById(id));
        return "view/employee/view";
    }

}
