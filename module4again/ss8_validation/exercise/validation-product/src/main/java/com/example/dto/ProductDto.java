package com.example.dto;

import com.example.model.Category;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ProductDto implements Validator {
    private Integer id;

    @NotEmpty
    @NotNull

    private String name;
    @NotEmpty
    @NotNull

    private String info;
    @NotNull
    @NotEmpty
    private String quantity;
    @NotEmpty
    @NotNull
    private String made;
    private Category category;

    public ProductDto() {
    }

    public ProductDto(Integer id, @NotEmpty @NotNull String name, @NotEmpty @NotNull String info, @NotNull @NotEmpty String quantity, @NotEmpty @NotNull String made, Category category) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.quantity = quantity;
        this.made = made;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getMade() {
        return made;
    }

    public void setMade(String made) {
        this.made = made;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
