package repository.employee.impl;

import model.employee.EducationDegree;
import repository.BaseRepository;
import repository.employee.EducationDegreeRepository;

import java.util.List;

public class EducationDegreeRepositoryImpl implements EducationDegreeRepository {
    private final BaseRepository baseRepository = new BaseRepository();
    private static final String SELECT_EDUCATION_DEGREE = "select * from education_degree";
    private static final String SELECT_EDUCATION_DEGREE_BY_ID = "select education_degree_name from education_degree where education_degree_id=?;";
    @Override
    public List<EducationDegree> selectAllEducationDegree() {
        return null;
    }

    @Override
    public EducationDegree selectEducationDegree(Integer educationDegreeId) {
        return null;
    }
}
