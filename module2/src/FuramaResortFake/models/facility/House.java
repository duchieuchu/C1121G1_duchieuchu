package FuramaResortFake.models.facility;

public class House extends Facility{
    private String roomStandard;
    private int numberOfFloor;

    public House(String idService, String serviceName, double usingArea, double costRent, int numberOfPeople, String rentalType, String roomStandard, int numberOfFloor) {
        super(idService, serviceName, usingArea, costRent, numberOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "idService='" + getIdService() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", UsingArea=" + getUsingArea() +
                ", costRent=" + getCostRent() +
                ", numberOfPeople=" + getNumberOfPeople() +
                ", rentalType='" + getRentalType() + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", numberOfFloor=" + numberOfFloor +
                '}';
    }
}
