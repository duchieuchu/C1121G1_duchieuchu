package com.example.model;

import javax.persistence.*;

@Entity
public class CardBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    @Column(columnDefinition = "DATE")
    private  String borrowStartDate;


    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public CardBorrow(String code, String borrowStartDate, Book book) {
        this.code = code;
        this.borrowStartDate = borrowStartDate;
        this.book = book;
    }

    public CardBorrow() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBorrowStartDate() {
        return borrowStartDate;
    }

    public void setBorrowStartDate(String borrowStartDate) {
        this.borrowStartDate = borrowStartDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
