package repository.impl;

import model.employee.EducationDegree;
import repository.employee.IEducationDegreeRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort1?allowPublicKeyRetrieval=true&useSSL=FALSE";
    private String jdbcUserName = "root";
    private String jdbcPassword = "codegym19";

    private static final String SELECT_EDUCATION_DEGREE = "select * from education_degree";
    private static final String SELECT_EDUCATION_DEGREE_BY_ID = "select education_degree_id,education_degree_name from education_degree where education_degree_id=?;";


    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        List<EducationDegree> educationDegrees = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EDUCATION_DEGREE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int educationDegreeId = resultSet.getInt("education_degree_id");
                String educationDegreeName = resultSet.getString("education_degree_name");
                educationDegrees.add(new EducationDegree(educationDegreeId, educationDegreeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegrees;
    }

    @Override
    public EducationDegree selectEducationDegree(int educationDegreeId) {
        EducationDegree educationDegree = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EDUCATION_DEGREE_BY_ID)) {
            preparedStatement.setInt(1, educationDegreeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String educationDegreeName = resultSet.getString("education_degree_name");

                educationDegree = new EducationDegree(educationDegreeId, educationDegreeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationDegree;
    }
}
