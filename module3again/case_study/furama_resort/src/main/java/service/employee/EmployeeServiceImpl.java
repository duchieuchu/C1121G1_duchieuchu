package service.employee;

import model.employee.Employee;
import repository.employee.EmployeeRepository;
import repository.employee.impl.EmployeeRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        this.employeeRepository.insertEmployee(employee);
    }

    @Override
    public Employee selectEmployee(Integer id) {
        return this.employeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return this.employeeRepository.selectAllEmployee();
    }

    @Override
    public void deleteEmployee(Integer id) throws SQLException {
        this.employeeRepository.deleteEmployee(id);
    }

    @Override
    public void update(Employee employee) throws SQLException {
        this.employeeRepository.update(employee);
    }

    @Override
    public List<Employee> finByName(String name) {
        return this.employeeRepository.finByName(name);
    }

    @Override
    public List<Employee> sortByName() {
        return this.employeeRepository.sortByName();
    }
}
