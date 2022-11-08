package com.example.book.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantity;
    private Double unitPrice;

    @ManyToOne()
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @ManyToOne()
    @JoinColumn(name = "orderItem", referencedColumnName = "id")
    private OrderItem orderItem;
}
