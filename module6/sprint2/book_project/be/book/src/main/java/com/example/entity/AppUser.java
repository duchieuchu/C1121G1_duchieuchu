package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userName;
    private String password;
    private String email;
    private String creationDate;
    @Column(columnDefinition = "BIT(1) DEFAULT 0")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "appUser")
    List<UserRole> userRoleList;

    @OneToMany(mappedBy = "appUser")
    List<Comment>commentList;

    @OneToOne(mappedBy = "appUser")
    private Customer customer;

}
