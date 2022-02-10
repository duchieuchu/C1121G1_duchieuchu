package FuramaResort.models.facility;

public class Villa extends Facility {
    //Tiêu chuẩn phòng, Diện tích hồ bơi, Số tầng.
    private String roomStandard;
    private double poolArea;
    private int numberOfFloors;

    public Villa() {
    }

    public Villa(String serviceName, double usingArea, double costRent, int personNumber,
                 String rentalType, String roomStandard, double poolArea, int numberOfFloors) {
        super(serviceName, usingArea, costRent, personNumber, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "serviceName='" + getServiceName() + '\'' +
                ", usingArea=" + getUsingArea() +
                ", costRent=" + getCostRent() +
                ", personNumber=" + getPersonNumber() +
                ", rentalType='" + getRentalType() + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }

    public String writeCSVFile() {
        return  getServiceName()+","+getUsingArea()+","+getCostRent()+","+getPersonNumber()+","+
                getRentalType()+","+getRoomStandard()+","+getPoolArea()+","+getNumberOfFloors();

    }
}
