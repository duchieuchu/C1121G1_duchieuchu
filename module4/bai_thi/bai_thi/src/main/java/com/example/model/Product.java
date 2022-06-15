package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private String status;

    @ManyToOne
    @JoinColumn(name = "typeProduct_id", referencedColumnName = "id")
    private TypeProduct typeProduct;

    @OneToMany(mappedBy = "product")
    List<Order> orderList;

    public Product() {
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public Product(Integer id, String name, double price, String status, TypeProduct typeProduct) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.typeProduct = typeProduct;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TypeProduct getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(TypeProduct typeProduct) {
        this.typeProduct = typeProduct;
    }
}
