package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String phoneNumber;

    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean isDeleted;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private AppUser appUser;

}
