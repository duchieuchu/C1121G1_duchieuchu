package com.example.repository;

import com.example.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    static Map<Integer, Student> studentMap;

    static {
        studentMap = new TreeMap<>();
        studentMap.put(234, new Student(234, "nguyen van a", "2000-05-05"));
        studentMap.put(235, new Student(235, "nguyen van b", "2000-06-05"));
        studentMap.put(236, new Student(236, "nguyen van c", "2000-07-05"));
    }

    @Override
    public Student findById(Integer id) {
        return studentMap.get(id);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    @Override
    public void save(Student student) {
        int id = (int) (Math.random() * 100);
        student.setId(id);
        studentMap.put(student.getId(), student);
    }
}
