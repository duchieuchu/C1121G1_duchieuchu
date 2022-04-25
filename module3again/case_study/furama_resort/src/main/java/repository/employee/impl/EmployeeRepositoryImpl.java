package repository.employee.impl;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.BaseRepository;
import repository.employee.DivisionRepository;
import repository.employee.EducationDegreeRepository;
import repository.employee.EmployeeRepository;
import repository.employee.PositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private final DivisionRepository divisionRepository = new DivisionRepositoryImpl();
    private final EducationDegreeRepository educationDegreeRepository = new EducationDegreeRepositoryImpl();
    private final PositionRepository positionRepository = new PositionRepositoryImpl();
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String INSERT_EMPLOYEE_SQL = "insert into employee (employee_name," +
            "employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id) values (?,?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set " +
            "employee_name =?" +
            ",employee_birthday=?" +
            ",employee_id_card=?" +
            ",employee_salary=?" +
            ",employee_phone=?" +
            ",employee_email=?" +
            ",employee_address=?" +
            ",position_id=?" +
            ",education_degree_id=?" +
            ",division_id=? " +
            "where employee_id=?;";
    private static final String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id=?;";

    @Override
    public void insertEmployee(Employee employee) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPosition().getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegree().getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivision().getDivisionId());
            preparedStatement.executeUpdate();
        } finally {
            baseRepository.close();
        }
    }

    @Override
    public Employee selectEmployee(Integer id) {
        List<Employee> employeeList = selectAllEmployee();
        Employee employee = null;
        for (Employee employee1 : employeeList) {
            if (employee1.getId() == id) {
                employee = employee1;
            }
        }
        return employee;
    }

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                Double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                Position position = positionRepository.selectPosition(resultSet.getInt("position_id"));
                EducationDegree educationDegree = educationDegreeRepository.selectEducationDegree(resultSet.getInt("education_degree_id"));
                Division division = divisionRepository.selectDivision(resultSet.getInt("division_id"));
                employees.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return employees;
    }

    @Override
    public void deleteEmployee(Integer id) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE_SQL)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        }finally {
            baseRepository.close();
        }
    }

    @Override
    public void update(Employee employee) throws SQLException {
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getBirthday());
            preparedStatement.setString(3, employee.getIdCard());
            preparedStatement.setDouble(4, employee.getSalary());
            preparedStatement.setString(5, employee.getPhone());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8, employee.getPosition().getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegree().getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivision().getDivisionId());
            preparedStatement.setInt(11, employee.getId());
            preparedStatement.executeUpdate();
        } finally {
            baseRepository.close();
        }
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
