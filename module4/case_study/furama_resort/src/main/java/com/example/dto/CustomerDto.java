package com.example.dto;

import com.example.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class CustomerDto implements Validator {
    private Integer id;

    private CustomerType customerType;

    @NotBlank(message = "name không được có khoảng trắng!")
    private String name;

    @NotEmpty(message = "dateOfBirth không được được để trống!")
    private String dateOfBirth;

    private Integer gender;

    private String idCard;

    private String phone;

    private String email;

    @NotBlank(message = "address không được có khoảng trắng!")
    private String address;

    private String code;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        if ((!customerDto.code.matches("^KH-\\d{4}$"))) {
            errors.rejectValue("code","customerCode.inValid","customerCode nhập không hợp lệ");
        }
        if (!customerDto.phone.matches("^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$")){
            errors.rejectValue("phone","phone.inValid","phone nhập không hợp lệ!");
        }
        if (!customerDto.email.matches("^[\\w#][\\w\\.\\'+#](.[\\w\\\\'#]+)\\@[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*(.[a-zA-Z]{2,20})$")){
            errors.rejectValue("email","email.inValid","email nhập không hợp lệ!");
        }
        if (!customerDto.idCard.matches("^(\\d{9})|(\\d{12})$")){
            errors.rejectValue("idCard","idCard.inValid","idCard nhập không hợp lệ!");
        }
    }
}
