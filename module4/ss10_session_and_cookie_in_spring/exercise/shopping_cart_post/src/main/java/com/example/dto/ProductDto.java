package com.example.dto;

import java.util.Objects;

public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private String image;
    private int price;

    public ProductDto() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
