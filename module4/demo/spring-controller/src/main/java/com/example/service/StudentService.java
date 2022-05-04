package com.example.service;

import com.example.model.Student;

import java.util.List;

public interface StudentService {
    Student findById(Integer id);
    List<Student> findAll();
    void save(Student student);
}
