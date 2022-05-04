package com.example.repository;

import com.example.model.Student;

import java.util.List;

public interface StudentRepository {
    Student findById(Integer id);
    List<Student>findAll();
    void save(Student student);

}
