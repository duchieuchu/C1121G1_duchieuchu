package com.example.dto;

import com.example.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CustomerDto implements Validator {
    private Integer id;

    private CustomerType customerType;

    @NotBlank(message = "name không được có khoảng trắng")
    @NotNull(message = "name không được để null")
    @NotEmpty(message = "name không được để trống")
    private String name;

    @NotBlank(message = "dateOfBirth không được có khoảng trắng")
    @NotNull(message = "dateOfBirth không được để null")
    @NotEmpty(message = "dateOfBirth không được để trống")
    private String dateOfBirth;

    private Integer gender;

    @NotBlank(message = "idCard không được có khoảng trắng")
    @NotNull(message = "idCard không được để null")
    @NotEmpty(message = "idCard không được để trống")
    private String idCard;

    @NotBlank(message = "phone không được có khoảng trắng")
    @NotNull(message = "phone không được để null")
    @NotEmpty(message = "phone không được để trống")
    private String phone;

    @NotBlank(message = "email không được có khoảng trắng")
    @NotNull(message = "email không được để null")
    @NotEmpty(message = "email không được để trống")
    private String email;

    @NotBlank(message = "address không được có khoảng trắng")
    @NotNull(message = "address không được để null")
    @NotEmpty(message = "address không được để trống")
    private String address;

    @NotBlank(message = "code không được có khoảng trắng")
    @NotNull(message = "code không được để null")
    @NotEmpty(message = "code không được để trống")
    private String code;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if ((!customerDto.code.matches("^KH-\\d{4}$"))) {
            errors.rejectValue("customerCode","customerCode.inValid","customerCode nhập không hợp lệ");
        }
        if (!customerDto.phone.matches("^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$")){
            errors.rejectValue("phone","phone.inValid","phone nhập không hợp lệ");
        }
        if (!customerDto.email.matches("^[\\w#][\\w\\.\\'+#](.[\\w\\\\'#]+)\\@[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*(.[a-zA-Z]{2,20})$")){
            errors.rejectValue("email","email.inValid","email nhập không hợp lệ");
        }
        if (!customerDto.idCard.matches("^(\\d{9})|(\\d{12})$")){
            errors.rejectValue("idCard","idCard.inValid","idCard nhập không hợp lệ");
        }
    }
}
