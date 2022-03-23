package repository.impl;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.employee.IDivisionRepository;
import repository.employee.IEducationDegreeRepository;
import repository.employee.IEmployeeRepository;
import repository.employee.IPositionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort1?allowPublicKeyRetrieval=true&useSSL=FALSE";
    private String jdbcUserName = "root";
    private String jdbcPassword = "codegym19";
    private final IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();
    private final IPositionRepository positionRepository = new PositionRepository();
    private final IDivisionRepository divisionRepository = new DivisionRepository();

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static final String SELECT_ALL_EMPLOYEES = "select * from employee";

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("SQLState: " + (((SQLException) e).getErrorCode()));
                System.err.println("Message: " + e.getMessage());
                Throwable throwable = ex.getCause();
                while (throwable != null) {
                    System.out.println("Cause" + throwable);
                    throwable = throwable.getCause();
                }
            }
        }
    }

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                String salary = resultSet.getString("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                Position position = positionRepository.selectPosition(resultSet.getInt("position_id"));
                EducationDegree educationDegree = educationDegreeRepository.selectEducationDegree(resultSet.getInt("education_degree_id"));
                Division division = divisionRepository.selectDivision(resultSet.getInt("division_id"));
                String userName = resultSet.getString("userName");
                employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, position, educationDegree, division, userName));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employeeList;
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
