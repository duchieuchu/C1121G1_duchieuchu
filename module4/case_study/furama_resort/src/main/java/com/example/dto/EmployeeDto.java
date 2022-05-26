package com.example.dto;

import com.example.model.employee.Division;
import com.example.model.employee.EducationDegree;
import com.example.model.employee.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class EmployeeDto implements Validator {
    private Integer id;

    @NotBlank(message = "name không được có khoảng trắng")
    private String name;

    @NotEmpty(message = "dateOfBirth không được được để trống!")
    private String dateOfBirth;

    private String idCard;
    private String salary;
    private String phone;
    private String email;

    @NotBlank(message = "address không được có khoảng trắng!")
    private String address;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if (!employeeDto.phone.matches("^((090)|(091)|([(]84[)][+]90)|([(]84[)][+]91))\\d{7}$")){
            errors.rejectValue("phone","phone.inValid","phone nhập không hợp lệ!");
        }
        if (!employeeDto.email.matches("^[\\w#][\\w\\.\\'+#](.[\\w\\\\'#]+)\\@[a-zA-Z0-9]+(.[a-zA-Z0-9]+)*(.[a-zA-Z]{2,20})$")){
            errors.rejectValue("email","email.inValid","email nhập không hợp lệ!");
        }
        if (!employeeDto.idCard.matches("^(\\d{9})|(\\d{12})$")){
            errors.rejectValue("idCard","idCard.inValid","idCard nhập không hợp lệ!");
        }
    }
}
