package com.example.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDto implements Validator {
    private Integer id;
    private String name;
    private String made;
    private String dayImport;
    private String expire;
    private Integer number;
    private Double price;
    private String image;
    private Boolean isDeleted;

    private CategoryDto categoryDto;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
