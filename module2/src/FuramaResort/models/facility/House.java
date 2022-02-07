package FuramaResort.models.facility;

public class House extends Facility {
    //Tiêu chuẩn phòng, Số tầng
    private String standardRoom;
    private int numberOfFloors;

    public House() {
    }

    public House(String serviceName, double usingArea, double costRent,
                 int personNumber, String rentalType, String standardRoom, int numberOfFloors) {
        super(serviceName, usingArea, costRent, personNumber, rentalType);
        this.standardRoom = standardRoom;
        this.numberOfFloors = numberOfFloors;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "serviceName='" + getServiceName() + '\'' +
                ", usingArea=" + getUsingArea() +
                ", costRent=" + getCostRent() +
                ", personNumber=" + getPersonNumber() +
                ", rentalType='" + getRentalType() + '\'' +
                ", standardRoom='" + standardRoom + '\'' +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
