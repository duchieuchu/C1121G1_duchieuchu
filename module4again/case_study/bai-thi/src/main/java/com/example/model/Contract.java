package com.example.model;

import javax.persistence.*;
import javax.swing.*;
import java.util.Date;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String contractCode;
    private String name;
    private String idCard;
    @Column(columnDefinition = "DATE")
    private String startDate;
    private String rentTime;
    private Double totalMoney;

    @ManyToOne
    @JoinColumn(name = "room_id",referencedColumnName = "id")
    private Room room;

    public Contract(Integer id, String contractCode, String name, String idCard, String startDate, String rentTime, Double totalMoney, Room room) {
        this.id = id;
        this.contractCode = contractCode;
        this.name = name;
        this.idCard = idCard;
        this.startDate = startDate;
        this.rentTime = rentTime;
        this.totalMoney = totalMoney;
        this.room = room;
    }

    public Contract() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getRentTime() {
        return rentTime;
    }

    public void setRentTime(String rentTime) {
        this.rentTime = rentTime;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
