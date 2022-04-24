package repository.employee.impl;

import model.employee.Position;
import repository.BaseRepository;
import repository.employee.PositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepositoryImpl implements PositionRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_POSITION = "select * from position";
    private static final String SELECT_POSITION_BY_ID = "select position_name from position where position_id=?;";

    @Override
    public List<Position> selectAllPosition() {
        List<Position> positions = new ArrayList<>();
        try(Connection connection = this.baseRepository.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(SELECT_POSITION)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                 Integer positionId =resultSet.getInt("position_id");
                 String positionName=resultSet.getString("position_name");
                 positions.add(new Position(positionId,positionName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            baseRepository.close();
        }
        return positions;
    }


    @Override
    public Position selectPosition(Integer positionId) {
            Position position = null;
            try(Connection connection = this.baseRepository.getConnection();PreparedStatement preparedStatement =connection.prepareStatement(SELECT_POSITION_BY_ID)){
                preparedStatement.setInt(1,positionId);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    String positionName=resultSet.getString("position_name");
                    position= new Position(positionId,positionName);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                baseRepository.close();
            }
        return position;
    }
}
