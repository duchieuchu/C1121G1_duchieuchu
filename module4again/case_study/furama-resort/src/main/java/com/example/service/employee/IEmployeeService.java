package com.example.service.employee;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    Page<Employee>findAll(Pageable pageable);
    void save(Employee employee);
    Employee findById(Integer id);
    void delete(Employee employee);

    Page<Employee>findAllByName(String name,Pageable pageable);

    List<Employee>findAll();
}
