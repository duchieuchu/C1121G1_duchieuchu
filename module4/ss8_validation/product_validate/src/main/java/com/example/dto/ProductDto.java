package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductDto implements Validator {
    private Integer id;
    @NotBlank(message = "name không được có khoảng trắng")
    @NotNull(message = "name không được để null")
    @NotEmpty(message = "name không được để trống")
    private String name;
    @NotNull(message = "price không được để null")
    private Double price;

    @NotBlank(message = "description không được có khoảng trắng")
    @NotNull(message = "description không được để null")
    @NotEmpty(message = "description không được để trống")
    private String description;

    @NotBlank(message = "brand không được có khoảng trắng")
    @NotNull(message = "brand không được để null")
    @NotEmpty(message = "brand không được để trống")
    private String brand;

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ProductDto productDto =(ProductDto) target;
        if (!productDto.name.matches("^[0-9.]*$")){
            errors.rejectValue("price","price.inValid","price nhập không hợp lệ");
        }
    }
}
