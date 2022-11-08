package com.example.book.dto;

import com.example.book.models.Category;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BookDto {
    private Integer id;
    @NotNull
    private String bookName;
    @NotNull
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private String image;
    @NotNull
    private Integer pageNumber;
    @NotNull
    private String authors;
    @NotNull
    private String publishingHouse;
    @NotNull
    private Integer quantity;
    @NotNull
    private Boolean isDeleted;
    @NotNull
    private Category category;
}
