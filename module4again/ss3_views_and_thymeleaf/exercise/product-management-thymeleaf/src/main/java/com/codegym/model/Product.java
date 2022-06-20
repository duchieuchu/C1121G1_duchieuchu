package com.codegym.model;

public class Product {
    private Integer id;
    private String name;
    private String info;
    private Integer quantity;
    private String made;

    public Product(Integer id, String name, String info, Integer quantity, String made) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.quantity = quantity;
        this.made = made;
    }

    public Product() {
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }
}
