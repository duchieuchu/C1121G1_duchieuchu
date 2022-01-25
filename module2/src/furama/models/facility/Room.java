package furama.models.facility;

public class Room extends Facility {
    //Dịch vụ miễn phí đi kèm
    private String freeService;

    public Room() {
    }

    public Room(String serviceName, double usingArea,
                double costRent, int personNumber, String rentalType, String freeService) {
        super(serviceName, usingArea, costRent, personNumber, rentalType);
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
                "serviceName='" + getServiceName() + '\'' +
                ", usingArea=" + getUsingArea() +
                ", costRent=" + getCostRent() +
                ", personNumber=" + getPersonNumber() +
                ", rentalType='" + getRentalType() + '\'' +
                ", freeService='" + freeService + '\'' +
                '}';
    }
}
