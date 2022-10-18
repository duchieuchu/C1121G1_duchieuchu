package com.example.book.dto;

import com.example.book.models.Category;
import lombok.Data;

@Data
public class BookDto {
    private Integer id;
    private String bookName;
    private String description;
    private Double price;
    private String image;
    private Integer pageNumber;
    private String authors;
    private String publishingHouse;
    private Boolean isDeleted;
    private Category category;
}
