package repository.impl;

import model.employee.Division;
import repository.employee.IDivisionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort1?allowPublicKeyRetrieval=true&useSSL=FALSE";
    private String jdbcUserName = "root";
    private String jdbcPassword = "codegym19";

    private static final String SELECT_DIVISION = "select * from division";
    private static final String SELECT_DIVISION_BY_ID = "select division_id,division_name from division where division_id=?;";


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

    @Override
    public List<Division> selectAllDivision() {
        List<Division> divisions = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIVISION)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                divisions.add(new Division(divisionId, divisionName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisions;
    }

    @Override
    public Division selectDivision(int divisionId) {
        Division division = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIVISION_BY_ID)) {
            preparedStatement.setInt(1, divisionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String divisionName = resultSet.getString("division_name");

                division = new Division(divisionId, divisionName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return division;
    }
}
