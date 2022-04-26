package service.employee;

import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    //    void insertEmployee(Employee employee) throws SQLException;
    Map<String, String> insertEmployee (Employee employee) throws SQLException;

    Employee selectEmployee(Integer id);

    List<Employee> selectAllEmployee();

    void deleteEmployee(Integer id) throws SQLException;

    Map<String, String> update(Employee employee) throws SQLException;
//    void update(Employee employee) throws SQLException;

    List<Employee> finByName(String name);

    List<Employee> sortByName();
}
