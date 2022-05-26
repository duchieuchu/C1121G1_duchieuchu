package com.example.dto;

import com.example.model.service.RentType;
import com.example.model.service.ServiceType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;

public class ServiceDto implements Validator {
    private Integer id;

    @NotBlank(message = "name không được có khoảng trắng")
    private String name;
    private String code;

    private String area;

    private String cost;

    private String maxPeople;

    private RentType rentType;

    private ServiceType serviceType;

    @NotBlank(message = "standardRoom không được có khoảng trắng")
    private String standardRoom;

    @NotBlank(message = "standardRoom không được có khoảng trắng")
    private String infoOther;

    private String poolArea;
    private String numberOfFloors;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }


    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getInfoOther() {
        return infoOther;
    }

    public void setInfoOther(String infoOther) {
        this.infoOther = infoOther;
    }


    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(String numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ServiceDto serviceDto = (ServiceDto) target;
        if ((!serviceDto.code.matches("^DV-\\d{4}$"))) {
            errors.rejectValue("code","serviceCode.inValid","employeeCode nhập không hợp lệ");
        }
        if ((!serviceDto.cost.matches("^[1-9]+[0-9.]*$"))) {
            errors.rejectValue("cost", "cost.inValid", "cost nhập không hợp lệ");
        }
        if ((!serviceDto.numberOfFloors.matches("^[1-9]+[0-9]*$"))) {
            errors.rejectValue("numberOfFloors", "numberOfFloors.inValid", "numberOfFloors nhập không hợp lệ");
        }
        if ((!serviceDto.maxPeople.matches("^[1-9]+[0-9]*$"))) {
            errors.rejectValue("maxPeople", "maxPeople.inValid", "maxPeople nhập không hợp lệ");
        }
        if ((!serviceDto.area.matches("^[1-9]+[0-9]*$"))) {
            errors.rejectValue("area", "area.inValid", "area nhập không hợp lệ");
        }

    }
}
