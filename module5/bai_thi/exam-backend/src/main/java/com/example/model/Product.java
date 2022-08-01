package com.example.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String made;
    private Integer price;
    private String unit;


@JsonBackReference
    @OneToMany(mappedBy = "product")
    private List<ProductBlock> productBlockList;


    public Product() {
    }

    public Product(Integer id, String name, String made, Integer price, String unit) {
        this.id = id;
        this.name = name;
        this.made = made;
        this.price = price;
        this.unit = unit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public List<ProductBlock> getProductBlockList() {
        return productBlockList;
    }

    public void setProductBlockList(List<ProductBlock> productBlockList) {
        this.productBlockList = productBlockList;
    }
}
