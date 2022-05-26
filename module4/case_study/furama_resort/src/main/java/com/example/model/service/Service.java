package com.example.model.service;

import com.example.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer area;
    private Double cost;
    private Integer maxPeople;

    @ManyToOne
    @JoinColumn(name = "rentType_id",referencedColumnName = "id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "serviceType_id",referencedColumnName = "id")
    private ServiceType serviceType;

    private String standardRoom;
    private String infoOther;
    private double poolArea;
    private Integer numberOfFloors;
    private String code;

    public Service(Integer id, String name, Integer area, Double cost, Integer maxPeople, RentType rentType, ServiceType serviceType, String standardRoom, String infoOther, double poolArea, Integer numberOfFloors, String code) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.rentType = rentType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.infoOther = infoOther;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.code = code;
    }

    public Service() {
    }
    @OneToMany(mappedBy = "service")
    private List<Contract> contractList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

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

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(Integer maxPeople) {
        this.maxPeople = maxPeople;
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
