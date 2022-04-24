package repository.employee;

import model.employee.Position;

import java.util.List;

public interface PositionRepository {
    List<Position> selectAllPosition();
    Position selectPosition (Integer positionId);
}
