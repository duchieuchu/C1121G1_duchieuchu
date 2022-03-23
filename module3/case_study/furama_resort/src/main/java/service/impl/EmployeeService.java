package service.impl;

import model.employee.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> selectAllEmployee() {
        return this.employeeRepository.selectAllEmployee();
    }

    @Override
    public Employee selectEmployee(String id) {
        return this.employeeRepository.selectEmployee(id);
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(String id) {
        employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> searchEmployee(String employeeName) {
        return null;
    }
}
