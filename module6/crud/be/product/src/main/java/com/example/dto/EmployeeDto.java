package com.example.dto;

import com.example.model.Gender;
import com.example.model.Position;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeDto implements Validator {
    private Integer id;
    private String code;
    private String name;
    private String dateOfBirth;
    private Boolean isDeleted;
    private Gender gender;

    private Position position;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
