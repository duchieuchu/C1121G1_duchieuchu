package com.example.model;

import javax.persistence.*;

@Entity
public class Bills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "DATE")
    private String createdDate;
    private String billType;
    private Integer quantity;
}
