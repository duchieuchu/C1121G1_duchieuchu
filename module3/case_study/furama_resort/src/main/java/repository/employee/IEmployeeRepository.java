package repository.employee;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> selectAllEmployee();

    Employee selectEmployee(String id);

    void insertEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(String id);

    List<Employee> searchEmployee(String employeeName);
}
