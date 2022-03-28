package service.impl;

import model.employee.Employee;
import repository.employee.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> selectAllEmployee() {
        return this.employeeRepository.selectAllEmployee();
    }

    @Override
    public Employee selectEmployee(int id) {
        return this.employeeRepository.selectEmployee(id);
    }

    @Override
    public void insertEmployee(Employee employee)  throws SQLException{
        employeeRepository.insertEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException{
        employeeRepository.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        this.employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> searchEmployee(String employeeName) {
        return null;
    }
}
