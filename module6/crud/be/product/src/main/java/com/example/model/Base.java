package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String baseCode;
    private String name;
    @Column(columnDefinition = "DATE")
    private String openDay;
    private String address;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;
    @ManyToOne()
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    private Employee employee;

}
