package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Integer id;
    @NotBlank(message = "firstName không được có khoảng trắng")
    @NotNull(message = "firstName không được để null")
    @NotEmpty(message = "firstName không được để trống")
    @Size(min = 5,max = 45,message = "độ dài phải 5-45 ký tự")
    private String firstName;

    @NotBlank(message = "lastName không được có khoảng trắng")
    @NotNull(message = "lastName không được để null")
    @NotEmpty(message = "lastName không được để trống")
    @Size(min = 5,max = 45,message = "độ dài phải 5-45 ký tự")
    private String lastName;


    private String phoneNumber;
    @NotNull
    @Min(value = 18, message = "tuổi phải >=18")
    private Integer age;
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto =(UserDto) target;
        if (!userDto.email.matches("^[\\w#][\\w\\.\\'+#](.[\\w\\\\'#]+)\\@[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*(.[a-zA-Z]{2,20})$")){
            errors.rejectValue("email","email.inValid","loi mac dinh");
        }
        if (!userDto.phoneNumber.matches("^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$")){
            errors.rejectValue("phoneNumber","phoneNumber.inValid","loi mac dinh");
        }
    }
}
