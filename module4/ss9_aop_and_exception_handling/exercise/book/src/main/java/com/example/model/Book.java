package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String author;
    private int quantityTotal;
    private int borrowedTotal;
    private int remainTotal;

    @OneToMany(mappedBy = "book")
    List<CardBorrow> cardBorrowList;

    public List<CardBorrow> getCardBorrowList() {
        return cardBorrowList;
    }

    public void setCardBorrowList(List<CardBorrow> cardBorrowList) {
        this.cardBorrowList = cardBorrowList;
    }

    public Book(Integer id, String name, String author, int quantityTotal, int borrowedTotal, int remainTotal, List<CardBorrow> cardBorrowList) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantityTotal = quantityTotal;
        this.borrowedTotal = borrowedTotal;
        this.remainTotal = remainTotal;
        this.cardBorrowList = cardBorrowList;
    }

    public Book(Integer id, String name, String author, int quantityTotal, int borrowedTotal, int remainTotal) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.quantityTotal = quantityTotal;
        this.borrowedTotal = borrowedTotal;
        this.remainTotal = remainTotal;
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

    public int getQuantityTotal() {
        return quantityTotal;
    }

    public void setQuantityTotal(int quantityTotal) {
        this.quantityTotal = quantityTotal;
    }

    public int getBorrowedTotal() {
        return borrowedTotal;
    }

    public void setBorrowedTotal(int borrowedTotal) {
        this.borrowedTotal = borrowedTotal;
    }

    public int getRemainTotal() {
        return remainTotal;
    }

    public void setRemainTotal(int remainTotal) {
        this.remainTotal = remainTotal;
    }
}
