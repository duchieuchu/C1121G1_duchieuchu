package com.example.dto;

import com.example.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private Integer id;
    @Pattern(regexp = "\"[^a-zA-Z\\s]]+\"")
    private String name;

    private String dateOfBirth;

    private Integer gender;

    private String idCard;

    private String phoneNumber;

    private String email;

    private String address;

    private CustomerType customerType;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
