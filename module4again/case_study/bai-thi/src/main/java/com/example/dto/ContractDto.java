package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ContractDto implements Validator {

    private Integer id;
    @NotEmpty
    @NotNull
    private String contractCode;
    @NotEmpty
    @NotNull
    private String name;
    @NotEmpty
    @NotNull
    private String idCard;
    @NotEmpty
    @NotNull
    private String startDate;
    @NotEmpty
    @NotNull
    private String rentTime;
    private Double totalMoney;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
