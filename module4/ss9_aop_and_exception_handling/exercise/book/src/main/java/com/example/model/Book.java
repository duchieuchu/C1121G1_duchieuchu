package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private Integer quantity;

    @OneToMany( mappedBy = "book")
    List<CardBorrow> cardBorrowList;

    public List<CardBorrow> getCardBorrowList() {
        return cardBorrowList;
    }

    public void setCardBorrowList(List<CardBorrow> cardBorrowList) {
        this.cardBorrowList = cardBorrowList;
    }

    public Book(Integer id, String name, String author, Integer quantity, List<CardBorrow> cardBorrowList) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
        this.cardBorrowList = cardBorrowList;
    }

    public Book(Integer id, String name, String author, Integer quantity) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantity = quantity;
    }

    public Book() {
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
