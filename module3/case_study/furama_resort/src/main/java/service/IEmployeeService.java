package service;

import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    List<Employee> selectAllEmployee();

    Employee selectEmployee(int id);

    void insertEmployee(Employee employee) throws SQLException;

    void updateEmployee(Employee employee) throws SQLException;

    boolean deleteEmployee(int id) throws SQLException;

    List<Employee> searchEmployee(String employeeName);
}
