package com.example.model.product;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;
    private String price;
    private String status;
    private String importDate;
    @Column(columnDefinition = "bit(1) default 0")
    private Boolean isDeleted;

    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    private String made;
    private Boolean gas;
    private Boolean sweat;
    private String author;
    private String typeBook;
    private String publicationDate;

}
