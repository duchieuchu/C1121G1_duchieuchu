package repository.impl;

import model.employee.Position;
import repository.employee.IPositionRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    private String jdbcURL = "jdbc:mysql://localhost:3306/furama_resort1?allowPublicKeyRetrieval=true&useSSL=FALSE";
    private String jdbcUserName = "root";
    private String jdbcPassword = "codegym19";

    private static final String SELECT_POSITION = "select * from position";
    private static final String SELECT_POSITION_BY_ID = "select position_id,position_name from position where position_id=?;";


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
    public List<Position> selectAllPosition() {
        List<Position> positions = new ArrayList<>();
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int positionId = resultSet.getInt("position_id");
                String positionName = resultSet.getString("position_name");
                positions.add(new Position(positionId, positionName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return positions;
    }

    @Override
    public Position selectPosition(int positionId) {
        Position position = null;
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION_BY_ID)) {
            preparedStatement.setInt(1, positionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String positionName = resultSet.getString("position_name");
                position = new Position(positionId, positionName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return position;
    }
}
