package repository.impl;

import model.employee.Employee;
import repository.IEmployeeRepository;

import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort1?allowPublicKeyRetrieval=true&useSSL=FALSE";
    private String jdbcUserName = "root";
    private String jdbcPassword = "codegym19";

    private static final String SELECT_ALL_EMPLOYEES = "select * from employee";
    @Override
    public List<Employee> selectAllEmployee() {
        return null;
    }

    @Override
    public Employee selectEmployee(String id) {
        return null;
    }

    @Override
    public void insertEmployee(Employee employee) {

    }

    @Override
    public void updateEmployee(Employee employee) {

    }

    @Override
    public void deleteEmployee(String id) {

    }

    @Override
    public List<Employee> searchEmployee(String employeeName) {
        return null;
    }
}
