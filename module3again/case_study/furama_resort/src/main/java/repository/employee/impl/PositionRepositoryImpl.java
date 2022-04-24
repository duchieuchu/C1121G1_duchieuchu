package repository.employee.impl;

import model.employee.Position;
import repository.BaseRepository;
import repository.employee.PositionRepository;

import java.util.List;

public class PositionRepositoryImpl implements PositionRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_POSITION = "select * from position";
    private static final String SELECT_POSITION_BY_ID = "select position_name from position where position_id=?;";
    @Override
    public List<Position> selectAllPosition() {
        return null;
    }

    @Override
    public Position selectPosition(Integer positionId) {
        return null;
    }
}
