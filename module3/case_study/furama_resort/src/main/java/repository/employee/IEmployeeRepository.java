package repository.employee;

import model.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeRepository {
    List<Employee> selectAllEmployee();

    Employee selectEmployee(int id);

    void insertEmployee(Employee employee) throws SQLException;

    void updateEmployee(Employee employee) throws SQLException;

    void deleteEmployee(int id) throws SQLException;

    List<Employee> searchEmployee(String employeeName);
}
