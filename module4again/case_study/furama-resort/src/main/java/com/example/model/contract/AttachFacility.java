package com.example.model.contract;

import javax.persistence.*;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 45,nullable = false)
    private String name;
    private Double cost;
    @Column(length = 10,nullable = false)
    private String unit;
    @Column(length = 45,nullable = false)
    private String status;
}
