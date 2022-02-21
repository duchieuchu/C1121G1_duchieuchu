package FuramaResortFake.models.facility;

public class Room extends Facility{
    private String freeService;

    public Room(String idService, String serviceName, double usingArea, double costRent, int numberOfPeople, String rentalType, String freeService) {
        super(idService, serviceName, usingArea, costRent, numberOfPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "idService='" + getIdService() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", UsingArea=" + getUsingArea() +
                ", costRent=" + getCostRent() +
                ", numberOfPeople=" + getNumberOfPeople() +
                ", rentalType='" + getRentalType() + '\'' +
                ", freeService='" + freeService + '\'' +
                '}';
    }
}
