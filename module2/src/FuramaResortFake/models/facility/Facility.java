package FuramaResortFake.models.facility;

public class Facility {
    // //Tên dịch vụ, Diện tích sử dụng, Chi phí thuê,
    //    // Số lượng người tối đa, Kiểu thuê (bao gồm thuê theo năm, tháng, ngày, giờ.
    private String idService;
    private String serviceName;
    private double UsingArea;
    private double costRent;
    private int numberOfPeople;
    private String rentalType;

    public Facility(String idService, String serviceName, double usingArea, double costRent, int numberOfPeople, String rentalType) {
        this.idService = idService;
        this.serviceName = serviceName;
        UsingArea = usingArea;
        this.costRent = costRent;
        this.numberOfPeople = numberOfPeople;
        this.rentalType = rentalType;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsingArea() {
        return UsingArea;
    }

    public void setUsingArea(double usingArea) {
        UsingArea = usingArea;
    }

    public double getCostRent() {
        return costRent;
    }

    public void setCostRent(double costRent) {
        this.costRent = costRent;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
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
                "idService='" + idService + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", UsingArea=" + UsingArea +
                ", costRent=" + costRent +
                ", numberOfPeople=" + numberOfPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }
}
