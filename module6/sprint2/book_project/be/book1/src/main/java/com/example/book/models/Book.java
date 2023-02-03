package com.example.book.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String bookName;
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    @Column(columnDefinition = "TEXT")
    private String image;
    private Integer pageNumber;
    private String authors;
    private String publishingHouse;
    private Integer quantity;
    @Column(columnDefinition = "BIT(1) default 0 ")
    private Boolean isDeleted;

    @ManyToOne()
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "book",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderDetails> orderDetailsList;

}
