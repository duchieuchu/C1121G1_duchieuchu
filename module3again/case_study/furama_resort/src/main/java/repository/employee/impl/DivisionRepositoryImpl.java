package repository.employee.impl;

import model.employee.Division;
import repository.BaseRepository;
import repository.employee.DivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepositoryImpl implements DivisionRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_DIVISION = "select * from division";
    private static final String SELECT_DIVISION_BY_ID = "select division_name from division where division_id=?;";

    @Override
    public List<Division> selectAllDivision() {
        List<Division> divisions = new ArrayList<>();
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIVISION)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Integer divisionId = resultSet.getInt("division_id");
                String divisionName = resultSet.getString("division_name");
                divisions.add(new Division(divisionId, divisionName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return divisions;
    }

    @Override
    public Division selectDivision(Integer divisionId) {
        Division division = null;
        try (Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DIVISION_BY_ID)) {
            preparedStatement.setInt(1, divisionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String divisionName = resultSet.getString("division_name");
                division = new Division(divisionId, divisionName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            baseRepository.close();
        }
        return division;
    }
}
