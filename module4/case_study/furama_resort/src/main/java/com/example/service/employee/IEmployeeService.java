package com.example.service.employee;

import com.example.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> getEmployeeByName(String name, Pageable pageable);

    Page<Employee>getEmployeeByInformation(String name,String division, Pageable pageable);

    void save(Employee employee);

    void delete(Employee employee);

    void update(Employee employee);

    Employee findById(Integer id);
}
