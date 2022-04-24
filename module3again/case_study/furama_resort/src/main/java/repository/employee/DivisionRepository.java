package repository.employee;

import model.employee.Division;

import java.util.List;

public interface DivisionRepository {
    List<Division>selectAllDivision();
    Division selectDivision (Integer divisionId);
}
