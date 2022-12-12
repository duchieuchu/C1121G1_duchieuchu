package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String name;
    private String image;
    private Double price;
    private Integer quantity;
    private String trademark;
    private Double saleOff;
    private Double priceForSaleOff ;

    @ManyToOne()
    @JoinColumn(name = "category", referencedColumnName = "id")
    private Category category;
}
