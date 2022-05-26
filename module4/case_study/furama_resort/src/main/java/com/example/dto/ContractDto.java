package com.example.dto;

import com.example.model.customer.Customer;
import com.example.model.employee.Employee;
import com.example.model.service.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


public class ContractDto implements Validator {
    private Integer id;

    @NotEmpty(message = "startDate không được được để trống!")
    private String startDate;

    @NotEmpty(message = "endDate không được được để trống!")
    private String endDate;

    private String deposit;

    private String totalMoney;

    private Employee employee;


    private Customer customer;

    private Service service;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public void setTotalMoney(String totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getTotalMoney() {
        return totalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;
        if ((!contractDto.deposit.matches("^[1-9]+[0-9.]*$"))) {
            errors.rejectValue("deposit","deposit.inValid","deposit nhập không hợp lệ");
        }
        if ((!contractDto.totalMoney.matches("^[1-9]+[0-9.]*$"))) {
            errors.rejectValue("totalMoney","totalMoney.inValid","totalMoney nhập không hợp lệ");
        }
    }

}
