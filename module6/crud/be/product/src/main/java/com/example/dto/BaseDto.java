package com.example.dto;

import com.example.model.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@RequiredArgsConstructor
public class BaseDto implements Validator {
    private Integer id;
    private String baseCode;
    private String name;
    private String openDay;
    private String address;
    private Boolean isDeleted;

    private EmployeeDto employeeDto;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
