package repository.employee.impl;

import model.employee.EducationDegree;
import repository.BaseRepository;
import repository.employee.EducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepositoryImpl implements EducationDegreeRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_EDUCATION_DEGREE = "select * from education_degree";
    private static final String SELECT_EDUCATION_DEGREE_BY_ID = "select education_degree_name from education_degree where education_degree_id=?;";
    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        List<EducationDegree>educationDegrees= new ArrayList<>();
        try(Connection connection =this.baseRepository.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EDUCATION_DEGREE)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Integer educationDegreeId =resultSet.getInt("education_degree_id");
                String educationDegreeName= resultSet.getString("education_degree_name");
                educationDegrees.add(new EducationDegree(educationDegreeId,educationDegreeName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            baseRepository.close();
        }
        return educationDegrees;
    }

    @Override
    public EducationDegree selectEducationDegree(Integer educationDegreeId) {
        EducationDegree educationDegree= null;
        try(Connection connection =this.baseRepository.getConnection();PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EDUCATION_DEGREE_BY_ID)){
            preparedStatement.setInt(1,educationDegreeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String educationDegreeName =resultSet.getString("education_degree_name");
                educationDegree= new EducationDegree(educationDegreeId,educationDegreeName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            baseRepository.close();
        }
        return educationDegree;
    }
}
