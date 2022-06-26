package com.example.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Integer id;
    @NotNull
//    @NotBlank
//    @NotEmpty
//@Size(min = 5,max = 45,message = "độ dài phải 5-45 ký tự")
    private String firstName;

//    @NotNull
//    @NotBlank
//    @NotEmpty
//@Size(min = 5,max = 45,message = "độ dài phải 5-45 ký tự")
    private String lastName;

//    @NotNull
//    @NotBlank
//    @NotEmpty
//    @Pattern(regexp = "^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$")
    private String phoneNumber;

    @NotNull
//    @NotBlank
//    @NotEmpty
    @Min(value = 18)
    private Integer age;

    @NotNull
//    @NotBlank
//    @NotEmpty
//    @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")
    private String email;

    public UserDto() {
    }

    public UserDto(Integer id, @NotNull @NotBlank @NotEmpty @Size(min = 5, max = 45) String firstName, @NotNull @NotBlank @NotEmpty @Size(min = 5, max = 45) String lastName, @NotNull @NotBlank @NotEmpty @Pattern(regexp = "^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$") String phoneNumber, @NotNull @NotBlank @NotEmpty @Min(value = 18) Integer age, @NotNull @NotBlank @NotEmpty @Pattern(regexp = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
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

    }
}
