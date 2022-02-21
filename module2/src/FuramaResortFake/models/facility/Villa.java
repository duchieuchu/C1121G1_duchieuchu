package FuramaResortFake.models.facility;

public class Villa extends Facility{
    private String roomStandard;
    private double poolArea;
    private int numberOfFloors;

    public Villa(String idService, String serviceName, double usingArea, double costRent, int numberOfPeople, String rentalType, String roomStandard, double poolArea, int numberOfFloors) {
        super(idService, serviceName, usingArea, costRent, numberOfPeople, rentalType);
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
                "idService='" + getIdService() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", UsingArea=" + getUsingArea() +
                ", costRent=" + getCostRent() +
                ", numberOfPeople=" + getNumberOfPeople() +
                ", rentalType='" + getRentalType() + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
