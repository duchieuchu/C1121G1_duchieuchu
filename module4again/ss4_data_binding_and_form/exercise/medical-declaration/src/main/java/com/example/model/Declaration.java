package com.example.model;

public class Declaration {
    private String name;
    private String dateOfBirth;
    private boolean gender;
    private String national;
    private String idCard;
    private String travelInfo;
    private String numberPlate;
    private String seatNumber;
    private String startDay;
    private String endDay;
    private String localArrive;

    public Declaration(String name, String dateOfBirth, boolean gender, String national, String idCard, String travelInfo, String numberPlate, String seatNumber, String startDay, String endDay, String localArrive) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.national = national;
        this.idCard = idCard;
        this.travelInfo = travelInfo;
        this.numberPlate = numberPlate;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.endDay = endDay;
        this.localArrive = localArrive;
    }

    public Declaration() {
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getNational() {
        return national;
    }

    public void setNational(String national) {
        this.national = national;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTravelInfo() {
        return travelInfo;
    }

    public void setTravelInfo(String travelInfo) {
        this.travelInfo = travelInfo;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getLocalArrive() {
        return localArrive;
    }

    public void setLocalArrive(String localArrive) {
        this.localArrive = localArrive;
    }
}
