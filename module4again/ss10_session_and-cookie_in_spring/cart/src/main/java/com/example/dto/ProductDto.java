package com.example.dto;

import javax.persistence.Column;
import java.util.Objects;

public class ProductDto {
    private Integer id;
    private String name;
    private String image;
    private Integer price;
    private String description;
    private Integer quantity;

    public ProductDto(Integer id, String name, String image, Integer price, String description, Integer quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public ProductDto() {
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null ||getClass() != o.getClass())return false;
        ProductDto productDto = (ProductDto) o;
        return id == productDto.id;
    }
    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
