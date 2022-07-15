package com.example.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private String city;

    @OneToOne
    @JoinColumn(name = "users_id",referencedColumnName = "id")
    private Users users;




}
