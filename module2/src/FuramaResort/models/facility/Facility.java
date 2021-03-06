package FuramaResort.models.facility;

public abstract class Facility {
    //Tên dịch vụ, Diện tích sử dụng, Chi phí thuê,
    // Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ.
    private String idFacility;
    private String serviceName;
    private double usingArea;
    private double costRent;
    private int personNumber;
    private String rentalType;

    public Facility() {
    }

    public Facility(String idFacility, String serviceName, double usingArea, double costRent, int personNumber, String rentalType) {
        this.idFacility = idFacility;
        this.serviceName = serviceName;
        this.usingArea = usingArea;
        this.costRent = costRent;
        this.personNumber = personNumber;
        this.rentalType = rentalType;
    }

    public String getIdFacility() {
        return idFacility;
    }

    public void setIdFacility(String idFacility) {
        this.idFacility = idFacility;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(double usingArea) {
        this.usingArea = usingArea;
    }

    public double getCostRent() {
        return costRent;
    }

    public void setCostRent(double costRent) {
        this.costRent = costRent;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(int personNumber) {
        this.personNumber = personNumber;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idFacility=" + idFacility +
                ", serviceName=" + serviceName +
                ", usingArea=" + usingArea +
                ", costRent=" + costRent +
                ", personNumber=" + personNumber +
                ", rentalType=" + rentalType +
                '}';
    }
    public String writeCSVFile(){
        return getIdFacility()+","+getServiceName()+","+getUsingArea()+","+getCostRent()+","+getPersonNumber()+","+
                getRentalType();
    }
}
