package repository.employee.impl;

import model.employee.Employee;
import repository.BaseRepository;
import repository.employee.EmployeeRepository;

import java.sql.SQLException;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    @Override
    public void insertEmployee(Employee employee) throws SQLException {

    }

    @Override
    public Employee selectEmployee(Integer id) {
        return null;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return null;
    }

    @Override
    public void deleteEmployee(Integer id) throws SQLException {

    }

    @Override
    public void update(Employee employee) throws SQLException {

    }

    @Override
    public List<Employee> finByName(String name) {
        return null;
    }

    @Override
    public List<Employee> sortByName() {
        return null;
    }
}
