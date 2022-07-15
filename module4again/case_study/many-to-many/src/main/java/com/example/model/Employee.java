package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(name = "employee_project",
            joinColumns = {@JoinColumn(name = "id_employee")},
            inverseJoinColumns = {@JoinColumn(name = "id_project")})
    List<Project>projectList;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
