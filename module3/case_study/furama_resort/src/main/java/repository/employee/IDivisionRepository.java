package repository.employee;

import model.employee.Division;

import java.util.List;

public interface IDivisionRepository {
    List<Division> selectAllDivision();

    Division selectDivision(int divisionId);
}
