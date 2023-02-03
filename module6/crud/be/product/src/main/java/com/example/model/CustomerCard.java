package com.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class CustomerCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String codeCard;
    private String customerName;
    private String idCard;
    @Column(columnDefinition = "DATE")
    private String dateOfBirth;
    @Column(columnDefinition = "DATE")
    private String registrationDate;
    @Column(columnDefinition = "DATE")
    private String expire;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "base_id",referencedColumnName = "id")
    private Base base;

}
