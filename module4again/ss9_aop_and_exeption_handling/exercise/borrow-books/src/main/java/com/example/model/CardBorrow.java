package com.example.model;

import javax.persistence.*;

@Entity
public class CardBorrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String borrower;
    private String borrowDate;

    @ManyToOne()
    @JoinColumn(name = "book_id",referencedColumnName = "id")

    private Book book;

    public CardBorrow(Integer id, String code, String borrower, String borrowDate, Book book) {
        this.id = id;
        this.code = code;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
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

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
