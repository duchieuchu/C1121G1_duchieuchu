package com.example.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String made;
    private Integer price;
    private String unit;

    @ManyToOne()
    @JoinColumn(name = "product_block_id", referencedColumnName = "id")
    private ProductBlock productBlock;

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

    public ProductBlock getProductBlock() {
        return productBlock;
    }

    public void setProductBlock(ProductBlock productBlock) {
        this.productBlock = productBlock;
    }
}
