package com.example.controller;

import com.example.model.employee.Employee;
import com.example.service.employee.IDivisionService;
import com.example.service.employee.IEducationDegreeService;
import com.example.service.employee.IEmployeeService;
import com.example.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/employeeRest")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/getOneEmployee")
    public ResponseEntity<Employee> getBlog(@RequestParam Integer id) {
        Employee employee = this.iEmployeeService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
