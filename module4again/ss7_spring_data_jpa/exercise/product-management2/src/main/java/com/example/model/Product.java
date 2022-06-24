package com.example.model;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id1;
    private String name1;
    private String info1;
    private Integer quantity1;
    private String made1;

    @ManyToOne()
    @JoinColumn(name = "category_id",referencedColumnName = "id1")
    private Category category;

    public Product(Integer id1, String name1, String info1, Integer quantity1, String made1) {
        this.id1 = id1;
        this.name1 = name1;
        this.info1 = info1;
        this.quantity1 = quantity1;
        this.made1 = made1;
    }

    public Product() {
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public Integer getQuantity1() {
        return quantity1;
    }

    public void setQuantity1(Integer quantity1) {
        this.quantity1 = quantity1;
    }

    public String getMade1() {
        return made1;
    }

    public void setMade1(String made1) {
        this.made1 = made1;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
