package com.example.book.dto;

import com.example.book.models.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDto {
    private Integer id;
    private Integer quantity;
    private Double unitPrice;

    private Book book;
}
