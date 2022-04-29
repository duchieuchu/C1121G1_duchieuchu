package model;

public class RentalType {
    private Integer rentalTypeId;
    private String rentalTypeName;

    public RentalType(Integer rentalTypeId, String rentalTypeName) {
        this.rentalTypeId = rentalTypeId;
        this.rentalTypeName = rentalTypeName;
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
}
