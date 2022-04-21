package model.service;

public class RentalType {
    private Integer rentalTypeId;
    private String rentalTypeName;
    private Double rentalTypeCost;

    public RentalType(Integer rentalTypeId, String rentalTypeName, Double rentalTypeCost) {
        this.rentalTypeId = rentalTypeId;
        this.rentalTypeName = rentalTypeName;
        this.rentalTypeCost = rentalTypeCost;
    }

    public Integer getRentalTypeId() {
        return rentalTypeId;
    }

    public void setRentalTypeId(Integer rentalTypeId) {
        this.rentalTypeId = rentalTypeId;
    }

    public String getRentalTypeName() {
        return rentalTypeName;
    }

    public void setRentalTypeName(String rentalTypeName) {
        this.rentalTypeName = rentalTypeName;
    }

    public Double getRentalTypeCost() {
        return rentalTypeCost;
    }

    public void setRentalTypeCost(Double rentalTypeCost) {
        this.rentalTypeCost = rentalTypeCost;
    }
}
