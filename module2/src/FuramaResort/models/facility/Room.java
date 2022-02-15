package FuramaResort.models.facility;

public class Room extends Facility {
    //Dịch vụ miễn phí đi kèm
    private String freeService;

    public Room() {
    }

    public Room(String idFacility, String serviceName, double usingArea,
                double costRent, int personNumber, String rentalType, String freeService) {
        super(idFacility, serviceName, usingArea, costRent, personNumber, rentalType);
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
                "idFacility=" + getIdFacility() +
                ", serviceName=" + getServiceName() +
                ", usingArea=" + getUsingArea() +
                ", costRent=" + getCostRent() +
                ", personNumber=" + getPersonNumber() +
                ", rentalType=" + getRentalType() +
                ", freeService='" + freeService +
                '}';
    }

    public String writeCSVFile() {
        return getIdFacility() + "," + getServiceName() + "," + getUsingArea() + "," + getCostRent()
                + "," + getPersonNumber() + "," + getRentalType() + "," + freeService;
    }
}
