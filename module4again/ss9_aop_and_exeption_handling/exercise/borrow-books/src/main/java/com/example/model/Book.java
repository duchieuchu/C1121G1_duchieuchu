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
    private String publicationDate;
    private Integer quantity;

    @OneToMany(mappedBy = "book")
    List<CardBorrow> cardBorrowList;

    @ManyToOne()
    @JoinColumn(name = "bookType_id",referencedColumnName = "id")
    private BookType bookType;

    public Book(Integer id, String name, String author, String publicationDate, Integer quantity, BookType bookType) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publicationDate = publicationDate;
        this.quantity = quantity;
        this.bookType = bookType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
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

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<CardBorrow> getCardBorrowList() {
        return cardBorrowList;
    }

    public void setCardBorrowList(List<CardBorrow> cardBorrowList) {
        this.cardBorrowList = cardBorrowList;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }
}
