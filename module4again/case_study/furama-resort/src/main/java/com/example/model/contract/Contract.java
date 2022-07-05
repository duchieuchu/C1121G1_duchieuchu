package com.example.model.contract;

import javax.persistence.*;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "DATETIME",nullable = false)
    private String startDate;
    @Column(columnDefinition = "DATETIME",nullable = false)
    private String endDate;
    private Double deposit;




}
